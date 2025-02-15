package com.adriangonzalezbesada.gymcodex.di

import android.app.Application
import androidx.room.Room
import com.adriangonzalezbesada.gymcodex.data.EjercicioDao
import com.adriangonzalezbesada.gymcodex.data.GymCodexDatabase
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import com.adriangonzalezbesada.gymcodex.data.repositorys.IEjercicioRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGymCodexDatabase(
        context: Application
    ) : GymCodexDatabase {
        return Room.databaseBuilder(
            context,
            GymCodexDatabase::class.java, "GymCodexDatabase"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideEjercicioDao(db: GymCodexDatabase): EjercicioDao {
        return db.ejercicioDao()
    }

    @Provides
    @Singleton
    fun provideEjercicioRepositoryImpl(
        ejercicioDao: EjercicioDao
    ) : IEjercicioRepository {
        return EjercicioRepositoryImpl(ejercicioDao)
    }

}