package khalid.com.polls.networkConnect

import android.util.Log
import khalid.com.polls.models.network.request.LoginRequest
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse
import retrofit2.Response

class PollNetworkDataSourceImpl(
    private val pollApiService: PollApiService,
    private val base: Base
) : PollNetworkDataSource {
    override suspend fun doSignUp(signUpRequest: SignUpRequest): AuthResponse? =
        base.safeApiCall(
            call = { pollApiService.signUpAsync(signUpRequest) })

    override suspend fun doLogin(loginRequest: LoginRequest): AuthResponse? = base.safeApiCall(
        call = { pollApiService.loginAsync(loginRequest) }
    )
}