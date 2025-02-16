package com.adriangonzalezbesada.gymcodex.di

import android.app.Application
import androidx.room.Room
import com.adriangonzalezbesada.gymcodex.data.EjercicioDao
import com.adriangonzalezbesada.gymcodex.data.GymCodexDatabase
import com.adriangonzalezbesada.gymcodex.data.repositorys.CommitAPIImpl
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import com.adriangonzalezbesada.gymcodex.data.repositorys.IEjercicioRepository
import com.adriangonzalezbesada.gymcodex.data.use_case.DeleteAllEjerciciosCase
import com.adriangonzalezbesada.gymcodex.data.use_case.DeleteEjercicioCase
import com.adriangonzalezbesada.gymcodex.data.use_case.GetAllEjerciciosCase
import com.adriangonzalezbesada.gymcodex.data.use_case.GetByNombreEjercicioCase
import com.adriangonzalezbesada.gymcodex.data.use_case.GetByTipoEntrenamientoCase
import com.adriangonzalezbesada.gymcodex.data.use_case.GetLastCommitInfoCase
import com.adriangonzalezbesada.gymcodex.data.use_case.InsertEjercicioCase
import com.adriangonzalezbesada.gymcodex.data.use_case.InsertEjerciciosCase
import com.adriangonzalezbesada.gymcodex.data.use_case.UpdateEjercicioCase
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

    // Use Cases

    @Provides
    @Singleton
    fun provideGetAllEjerciciosCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : GetAllEjerciciosCase {
        return GetAllEjerciciosCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideGetByNombreEjercicioCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : GetByNombreEjercicioCase {
        return GetByNombreEjercicioCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideGetByTipoEntrenamientoCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : GetByTipoEntrenamientoCase {
        return GetByTipoEntrenamientoCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideInsertEjercicioCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : InsertEjercicioCase {
        return InsertEjercicioCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideInsertEjerciciosCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : InsertEjerciciosCase {
        return InsertEjerciciosCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideUpdateEjercicioCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : UpdateEjercicioCase {
        return UpdateEjercicioCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideDeleteEjercicioCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : DeleteEjercicioCase {
        return DeleteEjercicioCase(ejercicioRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideDeleteAllEjerciciosCase(
        ejercicioRepositoryImpl: EjercicioRepositoryImpl
    ) : DeleteAllEjerciciosCase {
        return DeleteAllEjerciciosCase(ejercicioRepositoryImpl)
    }

}