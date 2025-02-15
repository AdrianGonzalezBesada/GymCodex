package com.adriangonzalezbesada.gymcodex.data.repositorys

import com.adriangonzalezbesada.gymcodex.data.LastCommitResponse
import retrofit2.Response
import retrofit2.http.GET

interface ICommitAPI {

    @GET("/repos/AdrianGonzalezBesada/GymCodex/commits/main")
    suspend fun getLastCommitInfo(): Response<LastCommitResponse>

}