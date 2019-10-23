package com.m7amdelbana.myapplication.network.api

import com.m7amdelbana.myapplication.R
import com.m7amdelbana.myapplication.app.App
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException

class APIError(throwable: Throwable) {

    var mesage: String? = null
    var code: Int? = 0

    init {
        formatThrowable(throwable)
    }

    private fun formatThrowable(throwable: Throwable) = if (throwable is HttpException) {
        mesage = parseErrorMessage(throwable)
        code = throwable.code()
    } else if (throwable is ConnectException) {
        mesage = App.context!!.getString(R.string.no_internet_connection)
        code = 402
    } else if (throwable is SocketTimeoutException || throwable is SocketException) {
        mesage = App.context!!.getString(R.string.request_time_out)
        code = 504
    } else {
        mesage = App.context!!.getString(R.string.server_error)
        code = 500
    }

    private fun parseErrorMessage(throwable: Throwable): String? {
        (throwable as HttpException).response()!!.errorBody()!!.charStream()
        try {
            val errorStr = throwable.response()!!.errorBody()!!.string()
            return try {
                errorStr
            } catch (e: JSONException) {
                e.printStackTrace()
                App.context!!.getString(R.string.server_error)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

}
