package khalid.com.polls.networkConnect

import java.io.IOException


/**
 * Created by  on 8/11/2019.
 */
sealed class Result<out T : Any> {
    object loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: IOException) : Result<Nothing>()
}