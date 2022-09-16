package app.yope.interview.dependencies

import app.yope.interview.BuildConfig
import app.yope.interview.service.IframelyService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

  @Singleton
  @Provides
  fun okhttp(): OkHttpClient =
    OkHttpClient.Builder()
      .apply {
        if (BuildConfig.DEBUG) {
          addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
          })
        }
      }
      .build()

  @Provides
  fun retrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .baseUrl("")
      .addConverterFactory(MoshiConverterFactory.create())
      .client(okHttpClient)
      .build()

  @Provides
  fun iframelyService(retrofit: Retrofit): IframelyService =
    retrofit.create(IframelyService::class.java)

  @Singleton
  @Provides
  fun moshi(): Moshi = Moshi.Builder().build()
}
