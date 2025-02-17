package com.adriangonzalezbesada.gymcodex.network

import android.util.Log
import com.adriangonzalezbesada.gymcodex.data.LastCommitResponse
import com.adriangonzalezbesada.gymcodex.data.RetrofitInstance
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class CommitAPIImpl @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) : ICommitAPI {

    override suspend fun getLastCommitInfo(): Response<LastCommitResponse> {

        return try {
            retrofitInstance.getLastCommitInfo()
        } catch (e: IOException) {
            Log.d("RetrofitInstance", "IOException")
            Response.error(
                500,
                "error".toResponseBody("IOException".toMediaTypeOrNull())
            )
        } catch (e: HttpException) {
            Log.d("RetrofitInstance", "HttpException")
            Response.error(
                e.code(),
                e.response()?.errorBody() ?: "error".toResponseBody("HttpException".toMediaTypeOrNull())
            )
        }
    }
}