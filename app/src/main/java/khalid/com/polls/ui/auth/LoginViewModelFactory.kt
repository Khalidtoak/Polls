package khalid.com.polls.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import khalid.com.polls.models.network.request.LoginRequest
import khalid.com.polls.repos.PollsRepo

/**
 * Created by  on 8/18/2019.
 */
@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
    private val pollsRepo: PollsRepo,
    private val loginRequest: LoginRequest
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(pollsRepo, loginRequest) as T
    }
}