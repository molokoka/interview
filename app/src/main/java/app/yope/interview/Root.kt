package app.yope.interview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.yope.interview.posts.Posts
import app.yope.interview.theme.ColorPalette

private sealed class RootScreen {
  object Root : RootScreen()
  object Posts : RootScreen()
  object Users : RootScreen()
}

@Composable
fun Root() {
  MaterialTheme(
    colors = ColorPalette,
    content = { RootContent() }
  )
}

@Composable
private fun RootContent() {
  var screen by remember { mutableStateOf<RootScreen>(RootScreen.Root) }

  Surface(
    modifier = Modifier.fillMaxSize(),
  ) {
    Box(
      modifier = Modifier
        .windowInsetsPadding(WindowInsets.navigationBars)
        .windowInsetsPadding(WindowInsets.statusBars)
    ) {
      when (screen) {
        RootScreen.Root -> Row(
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
          Button(
            onClick = { screen = RootScreen.Posts }
          ) {
            Text("posts")
          }
          Button(onClick = { }) {
            Text("users")
          }
        }
        RootScreen.Posts -> Posts(
          back = {
            screen = RootScreen.Root
          }
        )
        RootScreen.Users -> {
        }
      }
    }
  }
}
