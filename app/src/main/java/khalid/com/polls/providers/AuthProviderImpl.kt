package khalid.com.polls.providers

import android.content.Context

const val DEFAULT_AUTH_TOKEN = "Token"
const val DEFAULT_TOKEN_TYPE = "Bearer"
const val TOKEN_KEY = "Token"
const val TOKEN_TYPE_KEY = "Type"

class AuthProviderImpl(context: Context) : AuthProvider, PreferenceProvider(context) {
    private val appContext = context.applicationContext
    override suspend fun putDataInSharedPreferences(authToken: String, tokenType: String) {
        sharedPreferences?.edit()?.apply {
            putString(TOKEN_KEY, authToken)
            putString(TOKEN_TYPE_KEY, tokenType)
        }?.apply()
    }

    override fun getAuthTokenFromSharedPreferences(): String? = sharedPreferences?.getString(
        TOKEN_KEY, DEFAULT_AUTH_TOKEN
    )

    override fun getTokenTypeFrSharedPreferences(): String? = sharedPreferences?.getString(
        TOKEN_TYPE_KEY, DEFAULT_TOKEN_TYPE
    )
}