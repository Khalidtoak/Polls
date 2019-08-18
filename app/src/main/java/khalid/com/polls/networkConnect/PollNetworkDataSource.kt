package khalid.com.polls.networkConnect

import khalid.com.polls.models.network.request.LoginRequest
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse

/**
 * Created by  on 8/11/2019.
 */
interface PollNetworkDataSource {
    suspend fun doSignUp(signUpRequest: SignUpRequest): AuthResponse?
    suspend fun doLogin(loginRequest: LoginRequest): AuthResponse?
}