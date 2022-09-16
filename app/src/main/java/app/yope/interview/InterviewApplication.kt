package app.yope.interview

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalContext
import app.yope.interview.dependencies.ApplicationComponent
import app.yope.interview.dependencies.ApplicationModule
import app.yope.interview.dependencies.DaggerApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class YopeApplication : Application() {

  lateinit var component: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    initializeDaggerComponent()
  }

  private fun initializeDaggerComponent() {
    component = DaggerApplicationComponent
      .builder()
      .applicationModule(ApplicationModule(this))
      .build()
    component.inject(this)
  }
}

val Context.application: YopeApplication
  get() = applicationContext as YopeApplication

val Context.component: ApplicationComponent
  get() = application.component

@Composable
fun component(): ApplicationComponent {
  return LocalContext.current.applicationContext.component
}

@Composable
fun <T> rememberWithComponent(calculation: @DisallowComposableCalls ApplicationComponent.(CoroutineScope) -> T): T {
  val scope = rememberCoroutineScope()
  val component = component()
  return remember {
    calculation(component, scope)
  }
}

@Composable
fun <T, P> rememberWithComponent(
  params: P,
  calculation: @DisallowComposableCalls ApplicationComponent.(CoroutineScope, Flow<P>) -> T
): T {
  val scope = rememberCoroutineScope()
  val component = component()
  val paramsState by rememberUpdatedState(params)
  return remember {
    calculation(component, scope, snapshotFlow { paramsState })
  }
}
