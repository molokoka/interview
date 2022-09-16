package app.yope.interview.posts

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.yope.interview.data.Post
import app.yope.interview.posts.PostsState.Data
import app.yope.interview.posts.PostsState.Error
import app.yope.interview.posts.PostsState.Loading
import app.yope.interview.rememberWithComponent
import app.yope.interview.ui.HorizontalDivider

@Composable
fun Posts(back: () -> Unit) {

  BackHandler { back() }

  val presenter = rememberWithComponent { scope ->
    getPostsPresenterFactory().create(scope)
  }
  val state by presenter.state.collectAsState()

  when (val currentState = state) {
    is Data -> LazyColumn(
      modifier = Modifier.fillMaxSize(),
      content = {
        items(
          count = currentState.posts.size,
        ) { index ->
          val post = currentState.posts[index]

          HorizontalDivider()

          Post(post)

          if (index == currentState.posts.lastIndex) HorizontalDivider()
        }
      }
    )
    is Error -> Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Text(text = currentState.error.message ?: "unknown error")
    }
    Loading -> Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      CircularProgressIndicator()
    }
  }
}

@Composable
private fun Post(post: Post) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
  ) {
    Column(
      modifier = Modifier
        .align(Alignment.CenterStart)
        .padding(8.dp)
    ) {
      Text(text = post.title)
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = post.text)
    }

    Text(
      modifier = Modifier.align(Alignment.CenterEnd),
      text = post.authorId
    )
  }
}
