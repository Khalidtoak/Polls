package khalid.com.polls.providers

import android.content.Context

/*
* @author Khalidtoak
* @since  2019-12-28
*/
const val DEFAULT_AUTH_TOKEN = "Token"
const val DEFAULT_TOKEN_TYPE = "Bearer"
const val TOKEN_KEY = "Token"
const val TOKEN_TYPE_KEY = "Type"

class AuthProviderImpl(context: Context) : PreferenceProvider(context) {
     suspend fun putDataInSharedPreferences(authToken: String, tokenType: String) {
        sharedPreferences?.edit()?.apply {
            putString(TOKEN_KEY, authToken)
            putString(TOKEN_TYPE_KEY, tokenType)
        }?.apply()
    }

     fun getAuthTokenFromSharedPreferences(): String? = sharedPreferences?.getString(
        TOKEN_KEY, DEFAULT_AUTH_TOKEN
    )

    fun getTokenTypeFrSharedPreferences(): String? = sharedPreferences?.getString(
        TOKEN_TYPE_KEY, DEFAULT_TOKEN_TYPE
    )
}