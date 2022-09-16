package app.yope.interview.dependencies

import android.app.Application
import android.content.Context
import app.yope.interview.util.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class ApplicationModule(
  private val application: Application
) {

  @Provides
  @ApplicationContext
  fun provideContext(): Context = application

  @Provides
  fun provideApplication(): Application = application

  @Singleton
  @Provides
  fun provideCoroutineDispatchers() =
    AppCoroutineDispatchers(
      io = Dispatchers.IO,
      computation = Dispatchers.Default,
      main = Dispatchers.Main
    )
}
