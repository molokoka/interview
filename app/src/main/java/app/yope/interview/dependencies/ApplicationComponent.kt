package app.yope.interview.dependencies

import android.content.Context
import app.yope.interview.YopeApplication
import app.yope.interview.posts.PostsPresenterFactory
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class ApplicationContext

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

  fun inject(application: YopeApplication)

  @ApplicationContext
  fun getContext(): Context

  fun getPostsPresenterFactory(): PostsPresenterFactory
}
