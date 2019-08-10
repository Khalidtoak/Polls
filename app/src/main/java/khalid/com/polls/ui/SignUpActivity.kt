package khalid.com.polls.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import khalid.com.polls.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun goToLoginActivity(view: View) {
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
    }
    fun onBackPressed(view: View) {
        finish()
    }
}
