package com.adriangonzalezbesada.gymcodex.data

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInstance {

    @GET("/repos/AdrianGonzalezBesada/GymCodex/commits/main")
    fun getLastCommitInfo(): Response<LastCommitResponse>

}