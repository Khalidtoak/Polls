package khalid.com.polls.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import khalid.com.polls.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onBackPressed(view: View) {
        finish()
    }
    fun goToSignUpActivity(view: View) {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
    }
}
