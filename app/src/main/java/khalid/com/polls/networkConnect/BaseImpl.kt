package khalid.com.polls.networkConnect

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import java.io.IOException

class BaseImpl : Base {

    override suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>
    ): T? {
        val result = safeApiResult(call)
        var data: T? = null
        when (result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Log.d("1.DataRepository", result.exception.message, result.exception)
            }

        }
        return data
    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>)
            : Result<T> {
        val response = call.invoke()
        return if (response.isSuccessful) Result.Success(response.body()!!)
        else {
            Log.e("ErrorAuth", response.message())
            Result.Error(
                IOException(response.message())
            )
        }

    }
}