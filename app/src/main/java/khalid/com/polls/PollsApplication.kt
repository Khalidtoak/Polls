package khalid.com.polls

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import khalid.com.polls.feature.FeatureManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

/*
* @author Khalidtoak
* @since  2019-12-29
*/
class PollsApplication : SplitCompatApplication(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        //Import android x
        import(androidXModule(this@PollsApplication))
        //Import appModule
        import(appModule)
        //Import modules in other dfm's using reflectiom
        importAll(FeatureManager.kodeineModules)
    }

    private lateinit var context: Context
    override fun onCreate() {
        super.onCreate()
        context = this
    }

}