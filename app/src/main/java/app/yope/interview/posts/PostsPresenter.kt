package app.yope.interview.posts

import app.yope.interview.data.Post
import app.yope.interview.database.FirestoreDatabaseRepository
import app.yope.interview.posts.PostsState.Data
import app.yope.interview.posts.PostsState.Error
import app.yope.interview.posts.PostsState.Loading
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class PostsState {
  object Loading : PostsState()
  data class Data(val posts: List<Post>) : PostsState()
  data class Error(val error: Throwable) : PostsState()

  companion object {
    val Initial = Loading
  }
}

@AssistedFactory
interface PostsPresenterFactory {
  fun create(scope: CoroutineScope): PostsPresenter
}

class PostsPresenter @AssistedInject constructor(
  @Assisted private val scope: CoroutineScope,
  private val database: FirestoreDatabaseRepository,
) {
  private val mutableState = MutableStateFlow<PostsState>(PostsState.Initial)
  val state = mutableState.asStateFlow()

  init {
    getPosts()
  }

  private fun getPosts() {
    scope.launch {
      mutableState.update {
        Loading
      }
      try {
        val posts = database.observePosts().first()
        mutableState.update { Data(posts) }
      } catch (throwable: Throwable) {
        mutableState.update { Error(throwable) }
      }
    }
  }
}
