package com.adriangonzalezbesada.gymcodex.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Ejercicio::class], version = 1)
@TypeConverters(Converters::class)
abstract class GymCodexDatabase : RoomDatabase() {
    abstract fun ejercicioDao(): EjercicioDao
}