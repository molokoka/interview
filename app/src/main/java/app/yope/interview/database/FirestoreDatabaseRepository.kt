package app.yope.interview.database

import app.yope.interview.data.Post
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

private const val POSTS_COLLECTION = "posts"
private const val USERS_COLLECTION = "users"

private const val THREAD_TEXT_FIELD = "text"
private const val THREAD_TITLE_FIELD = "title"
private const val THREAD_AUTHOR_ID_FIELD = "authorId"

class FirestoreDatabaseRepository @Inject constructor() {

  private val db = Firebase.firestore

  suspend fun getPosts(): List<Post> =
    db.collection(POSTS_COLLECTION)
      .get()
      .await()
      .let { result ->
        result
          .documents
          .mapNotNull { document ->
            parsePost(document)
          }
      }

  suspend fun observePosts(): Flow<List<Post>> = callbackFlow {
    val replies = db.collection(POSTS_COLLECTION)

    val registration = replies.addSnapshotListener { value, error ->
      error?.let { cause ->
        cancel(CancellationException("post snapshotListener failed", cause))
      }

      value
        ?.documents
        ?.mapNotNull {
          parsePost(it)
        }
        ?.let {
          trySend(it)
        }
    }

    awaitClose { registration.remove() }
  }

  suspend fun getPost(postId: String): Post =
    db.document("$POSTS_COLLECTION/$postId")
      .get()
      .await()
      .let { document ->
        parsePost(document)
      }

  private fun parsePost(document: DocumentSnapshot): Post {
    return Post(
      id = document.id,
      text = document.getString(THREAD_TEXT_FIELD)!!,
      title = document.getString(THREAD_TITLE_FIELD)!!,
      authorId = document.getString(THREAD_AUTHOR_ID_FIELD)!!
    )
  }
}
