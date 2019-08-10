package khalid.com.polls.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import khalid.com.polls.R
import khalid.com.polls.models.IntroData
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfIntros = listOf(IntroData(getDrawable(R.drawable.ic_create)!!, getString(R.string.create_poll)),
            IntroData(getDrawable(R.drawable.ic_social_share)!!, getString(R.string.share_polls)),
            IntroData(getDrawable(R.drawable.ic_voting)!!, getString(R.string.vote_intro))
        )
        viewpager.adapter = IntroSlideAdapter(listOfIntros, this@MainActivity)
        viewpager.setPageTransformer(ZoomOutPageTransformer())
        sign_up_button.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
        }
        login_button.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
    }
}
