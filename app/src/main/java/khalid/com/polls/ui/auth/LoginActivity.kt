package khalid.com.polls.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import khalid.com.polls.R
import khalid.com.polls.models.network.request.LoginRequest
import khalid.com.polls.ui.ScreenState
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.factory

class LoginActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private lateinit var loginViewModel: LoginViewModel
    private val loginViewModelFactory: ((LoginRequest) -> LoginViewModelFactory) by factory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener {
            if (anyOfTheFieldsAreEmpty()) return@setOnClickListener
            initViewModel()
            observeData(it)
        }
    }

    private fun observeData(it: View) {
        loginViewModel.getAuthData().observe(this@LoginActivity, Observer { auth ->
            when (auth) {
                is ScreenState.loading ->
                    toggleVisibilityForLoading()
                is ScreenState.Success -> {
                    toggleVisibilityForFailure()
                    Toast.makeText(this@LoginActivity, "${auth.data}", Toast.LENGTH_LONG).show()
                }
                is ScreenState.Error -> {
                    toggleVisibilityForFailure()
                    Snackbar.make(
                        it, "Sorry, ${auth.exception.message}", Snackbar.LENGTH_LONG
                    ).show()
                }

            }
        })
    }

    private fun toggleVisibilityForLoading() {
        progressBar2.visibility = View.VISIBLE
        button.visibility = View.INVISIBLE
    }

    private fun toggleVisibilityForFailure() {
        progressBar2.visibility = View.INVISIBLE
        button.visibility = View.VISIBLE
    }

    fun onBackPressed(view: View) {
        finish()
    }

    fun goToSignUpActivity(view: View) {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
    }

    private fun initViewModel() {
        loginViewModel = ViewModelProvider(
            this@LoginActivity, loginViewModelFactory(
                LoginRequest(password.text.toString(), user_nameOr_Email.text.toString())
            )
        ).get(LoginViewModel::class.java)
    }

    private fun anyOfTheFieldsAreEmpty(): Boolean {
        if (user_nameOr_Email.text.toString().isEmpty()) {
            user_nameOr_Email.error = "user name or email cannot be empty"
            return true
        }
        if (password.text.toString().isEmpty()) {
            password.error = "password cannot be null"
            return true
        }
        return false
    }
}
