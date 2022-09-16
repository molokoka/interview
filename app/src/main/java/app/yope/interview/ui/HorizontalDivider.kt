package app.yope.interview.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDivider(
  modifier: Modifier = Modifier,
  color: Color = Color.White.copy(alpha = .1f)
) {
  Box(
    modifier
      .fillMaxWidth()
      .height(1.dp)
      .background(color = color)
  )
}
