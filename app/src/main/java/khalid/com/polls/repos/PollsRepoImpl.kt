package khalid.com.polls.repos

import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse
import khalid.com.polls.networkConnect.PollNetworkDataSource
import khalid.com.polls.networkConnect.Result
import khalid.com.polls.providers.AuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PollsRepoImpl(
    private val pollNetworkDataSource: PollNetworkDataSource,
    private val authProvider: AuthProvider
) : PollsRepo {
    override suspend fun fetchUserFromServer(signUpRequest: SignUpRequest): AuthResponse? {
        return withContext(Dispatchers.IO) {
            val doSignUp = pollNetworkDataSource.doSignUp(signUpRequest)
            authProvider.putDataInSharedPreferences(doSignUp!!.accessToken, doSignUp.tokenType)
            return@withContext doSignUp
        }
    }

}