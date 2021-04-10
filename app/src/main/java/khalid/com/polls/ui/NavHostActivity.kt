package khalid.com.polls.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import khalid.com.polls.R
import kotlinx.android.synthetic.main.activity_nav_host.*

class NavHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        setUpBottomNav()
    }
/*
* Sets up bottom nav and base fragment with navigation View*/
    private fun setUpBottomNav(){
        val navController = fragment.findNavController()
        bottomNavigationView.setupWithNavController(navController)
    }
}
