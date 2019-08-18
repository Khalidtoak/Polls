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
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.networkConnect.Result
import khalid.com.polls.ui.ScreenState
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.sign_up_button
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.factory

class SignUpActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private lateinit var signUpViewModel: SignUpViewModel
    private val signUpViewModelFactory: ((SignUpRequest) -> SignUpViewModelFactory) by factory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_button.setOnClickListener {
            if (anyOfTheFieldsIsEmpty()) return@setOnClickListener
            observeAuthData(it)
        }

    }

    fun goToLoginActivity(view: View) {
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
    }

    fun onBackPressed(view: View) {
        finish()
    }

    private fun observeAuthData(view: View) {
        progressBar.visibility = View.VISIBLE
        signUpViewModel = ViewModelProvider(
            this@SignUpActivity, signUpViewModelFactory(
                SignUpRequest(
                    email.text.toString(), user_name.text.toString(), password.text.toString()
                    , user_name.text.toString()
                )
            )
        ).get(SignUpViewModel::class.java)
        signUpViewModel.authData().observe(this@SignUpActivity, Observer { auth ->
            progressBar.visibility = View.INVISIBLE
            when (auth) {
                is ScreenState.Success -> {
                    Toast.makeText(
                        this@SignUpActivity,
                        "Token: ${auth.data.accessToken} and tokenType ${auth.data.tokenType} ",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is ScreenState.Error -> {
                    Snackbar.make(
                        view, "Sorry, ${auth.exception.message}", Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    private fun anyOfTheFieldsIsEmpty(): Boolean {
        if (user_name.text.toString().isEmpty()) {
            user_name.error = "Username cannot be empty"
            return true
        }
        if (email.text.toString().isEmpty()) {
            email.error = "email cannot be empty"
            return true
        }
        if (password.text.toString().isEmpty()) {
            password.error = "password cannot be empty"
            return true
        }
        if (user_name.text.toString().length < 3) {
            user_name.error = "Username must be greater than 3 characters"
            return true
        }
        if (password.text.toString().length < 6 || password.text.toString().length > 20) {
            password.error = "password must be at least 6 chars"
            return true
        }
        return false
    }
}
