package khalid.com.polls

import khalid.com.polls.providers.AuthProviderImpl
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* @author Khalidtoak
* @since  2019-12-27
*/
val appModule = Kodein.Module("appModule") {

    /*
    * Provides shared Preferences for authentication*/
    bind() from singleton { AuthProviderImpl(instance()) }

    /*provides Auth interceptor
    * */
    bind() from singleton {
        AuthInterceptor(
            instance<AuthProviderImpl>().getAuthTokenFromSharedPreferences() ?: ""
        )
    }
    /*
    * Provides retrofit.builder*/
    bind<Retrofit.Builder>() with singleton { Retrofit.Builder() }
    /*
    * Provides HttpClient builder
    * */
    bind<OkHttpClient.Builder>() with singleton { OkHttpClient.Builder() }
    //Provides HttpClient
    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
            .addInterceptor(instance<AuthInterceptor>()).build()
    }
    //Provides retrofit
    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(instance())
            .build()
    }

}
