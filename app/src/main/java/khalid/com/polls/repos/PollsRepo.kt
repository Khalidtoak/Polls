package khalid.com.polls.repos

import androidx.lifecycle.LiveData
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse
import khalid.com.polls.networkConnect.Result

/**
 * Created by  on 8/11/2019.
 */
interface PollsRepo {
    suspend fun fetchUserFromServer(signUpRequest: SignUpRequest): AuthResponse?
}