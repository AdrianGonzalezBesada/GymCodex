package com.adriangonzalezbesada.gymcodex.di

import android.content.Context
import androidx.room.Room
import com.adriangonzalezbesada.gymcodex.data.GymCodexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    fun provideGymCodexDatabase(
        @ApplicationContext context: Context
    ) : GymCodexDatabase {
        return Room.databaseBuilder(
            context,
            GymCodexDatabase::class.java, "GymCodexDatabase"
        ).fallbackToDestructiveMigration().build()
    }

}