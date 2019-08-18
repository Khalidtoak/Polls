package khalid.com.polls.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import khalid.com.polls.models.network.request.LoginRequest

import khalid.com.polls.repos.PollsRepo
import khalid.com.polls.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Created by  on 8/18/2019.
 */
class LoginViewModel(
    private val
    pollsRepo: PollsRepo, private val loginRequest: LoginRequest
) : ViewModel() {
    fun getAuthData() = liveData(Dispatchers.Main) {
        emit(ScreenState.loading)
        try {
            emit(ScreenState.Success(pollsRepo.fetchUserFromLogin(loginRequest)!!))
        } catch (exception: IOException) {
            emit(ScreenState.Error(exception))
        }
    }
}