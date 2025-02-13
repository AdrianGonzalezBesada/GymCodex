package com.adriangonzalezbesada.gymcodex.di

import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import com.adriangonzalezbesada.gymcodex.data.repositorys.IEjercicioRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EjercicioRepositoryModule {

    @Binds
    abstract fun bindIEjercicioRepository(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : IEjercicioRepository

}