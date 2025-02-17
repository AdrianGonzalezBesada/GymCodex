package com.adriangonzalezbesada.gymcodex.data

import com.adriangonzalezbesada.gymcodex.network.ICommitAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceHiltnt {

    val api: ICommitAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ICommitAPI::class.java)
    }

}