package com.adriangonzalezbesada.gymcodex.di

import com.adriangonzalezbesada.gymcodex.data.RetrofitInstance
import com.adriangonzalezbesada.gymcodex.network.CommitAPIImpl
import com.adriangonzalezbesada.gymcodex.domain.use_case.GetLastCommitInfoCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModules {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): RetrofitInstance {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInstance::class.java)
    }

    @Provides
    @Singleton
    fun provideCommitAPIImpl(
        retrofitInstance: RetrofitInstance
    ) : CommitAPIImpl {
        return CommitAPIImpl(retrofitInstance)
    }

    // Use Cases

    @Provides
    @Singleton
    fun provideGetLastCommitInfoCase(
        commitAPIImpl: CommitAPIImpl
    ) : GetLastCommitInfoCase {
        return GetLastCommitInfoCase(commitAPIImpl)
    }

}