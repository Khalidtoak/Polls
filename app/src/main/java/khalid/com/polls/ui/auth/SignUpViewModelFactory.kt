package khalid.com.polls.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.networkConnect.Base
import khalid.com.polls.repos.PollsRepo

/**
 * Created by  on 8/12/2019.
 */
@Suppress("UNCHECKED_CAST")
class SignUpViewModelFactory(
    private val pollsRepo: PollsRepo,
    private val signUpRequest: SignUpRequest
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(pollsRepo, signUpRequest) as T
    }
}