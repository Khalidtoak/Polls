package khalid.com.polls
import okhttp3.Interceptor
import okhttp3.Response

/*
* @author Khalidtoak
* @since  2019-12-28
*/
class AuthInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().addHeader(
                "authToken",
                "Bearer $authToken"
            ).build()
        )
    }

}