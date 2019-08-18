package khalid.com.polls.networkConnect

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import khalid.com.polls.models.network.request.LoginRequest
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by  on 8/10/2019.
 */
interface PollApiService {
    @POST("/api/auth/signup")
    suspend fun signUpAsync(@Body signUpRequest: SignUpRequest): Response<AuthResponse>

    @POST("/api/auth/signin")
    suspend fun loginAsync(@Body loginRequest: LoginRequest): Response<AuthResponse>

    companion object {
        operator fun invoke(): PollApiService {
            val okHttpClient =
                OkHttpClient.Builder().build()
            return Retrofit.Builder().client(okHttpClient)
                .baseUrl("http://polls-api2019.herokuapp.com")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PollApiService::class.java)
        }
    }
}