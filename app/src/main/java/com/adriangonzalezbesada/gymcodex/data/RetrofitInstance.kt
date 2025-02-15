package com.adriangonzalezbesada.gymcodex.data

import com.adriangonzalezbesada.gymcodex.data.repositorys.ICommitAPI
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitInstance {

    @GET("/repos/AdrianGonzalezBesada/GymCodex/commits/main")
    fun getLastCommitInfo(): Response<LastCommitResponse>

}