package khalid.com.polls.networkConnect

import retrofit2.Response
import java.io.IOException

/**
 * Created by  on 8/11/2019.
 */
interface Base {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T?
}