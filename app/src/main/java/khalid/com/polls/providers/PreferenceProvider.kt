package khalid.com.polls.providers

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/*
* @author Khalidtoak
* @since  2019-12-28
*/
abstract class PreferenceProvider(context: Context){
    protected val sharedPreferences : SharedPreferences?
            = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
}