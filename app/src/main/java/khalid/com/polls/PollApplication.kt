package khalid.com.polls

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import khalid.com.polls.models.network.request.SignUpRequest
import khalid.com.polls.networkConnect.*
import khalid.com.polls.providers.AuthProvider
import khalid.com.polls.providers.AuthProviderImpl
import khalid.com.polls.repos.PollsRepo
import khalid.com.polls.repos.PollsRepoImpl
import khalid.com.polls.ui.auth.SignUpViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by  on 8/11/2019.
 */
class PollApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@PollApplication))
        bind<Base>() with singleton { BaseImpl() }
        bind() from singleton { PollApiService() }
        bind<PollNetworkDataSource>() with singleton {
            PollNetworkDataSourceImpl(
                instance(),
                instance()
            )
        }
        bind<AuthProvider>() with singleton { AuthProviderImpl(instance()) }
        bind<PollsRepo>() with singleton { PollsRepoImpl(instance(), instance()) }
        bind() from factory { signUpRequest: SignUpRequest ->
            SignUpViewModelFactory(instance(), signUpRequest)
        }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        // PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}