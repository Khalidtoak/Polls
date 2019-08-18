package khalid.com.polls.ui.auth

import android.util.Log
import androidx.lifecycle.*
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.models.network.response.auth.AuthResponse
import khalid.com.polls.networkConnect.Result
import khalid.com.polls.repos.PollsRepo
import khalid.com.polls.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by  on 8/12/2019.
 */
class SignUpViewModel(
    private val
    pollsRepo: PollsRepo,
    private val signUpRequest: SignUpRequest
) : ViewModel() {
    fun authData() = liveData(Dispatchers.Main) {
        try {
            val auth = pollsRepo.fetchUserFromServer(signUpRequest)
            emit(ScreenState.Success(auth!!))
        } catch (io: IOException) {
            emit(ScreenState.Error(io))
        }
    }
}

