package app.yope.interview.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface IframelyService {

  @GET("https://cdn.iframe.ly/api/iframely")
  suspend fun getIframely(
    @Query("api_key") apiKey: String = "",
    @Query("url") url: String,
    @Query("iframe") iframe: String = "card",
    @Query("omit_css") omitCss: String = "card",
  ): ResponseBody
}
