package khalid.com.polls.providers

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by  on 8/16/2019.
 */
abstract class PreferenceProvider(context: Context) {
    protected val sharedPreferences: SharedPreferences? =
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
}