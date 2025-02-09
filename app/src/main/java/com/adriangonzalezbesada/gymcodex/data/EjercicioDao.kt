package com.adriangonzalezbesada.gymcodex.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EjercicioDao {

    @Query("SELECT * FROM ejercicios")
    fun getAll(): Flow<List<Ejercicio>>

    @Query("SELECT * FROM ejercicios WHERE nombre_ejercicio = :nombre_ejercicio")
    fun getByNombreEjercicio(nombre_ejercicio: String): Flow<List<Ejercicio>>

    @Query("SELECT * FROM ejercicios WHERE tipo_entrenamiento = :tipo_entrenamiento")
    fun getByTipoEntrenamiento(tipo_entrenamiento: String): Flow<List<Ejercicio>>

    @Update
    fun updateEjercicio(ejercicio: Ejercicio)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEjercicio(ejercicio: Ejercicio)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEjercicios(ejercicios: List<Ejercicio>)

    @Delete
    fun deleteEjercicio(ejercicio: Ejercicio)

    @Query("DELETE FROM ejercicios")
    suspend fun deleteAllEjercicios()




}