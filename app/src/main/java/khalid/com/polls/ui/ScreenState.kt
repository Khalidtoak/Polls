package khalid.com.polls.ui

import java.io.IOException

/**
 * Created by  on 8/18/2019.
 */
sealed class ScreenState<out T : Any> {
    object loading : ScreenState<Nothing>()
    data class Success<out T : Any>(val data: T) : ScreenState<T>()
    data class Error(val exception: IOException) : ScreenState<Nothing>()
}