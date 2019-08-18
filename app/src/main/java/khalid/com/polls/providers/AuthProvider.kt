package khalid.com.polls.providers

/**
 * Created by  on 8/16/2019.
 */
interface AuthProvider {
    suspend fun putDataInSharedPreferences(authToken: String, tokenType: String)
    fun getAuthTokenFromSharedPreferences(): String?
    fun getTokenTypeFrSharedPreferences(): String?
}