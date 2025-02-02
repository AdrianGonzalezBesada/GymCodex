package com.adriangonzalezbesada.gymcodex.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EjercicioDao {

    @Query("SELECT * FROM ejercicios")
    fun getAll(): List<Ejercicio>

    @Query("SELECT * FROM ejercicios WHERE id_ejercicio = :id_ejercicio")
    fun loadById(id_ejercicio: Int): Flow<List<Ejercicio>>

    @Update
    fun updateEjercicio(ejercicio: Ejercicio)

    @Insert
    fun insertEjercicio(ejercicio: Ejercicio)

    @Delete
    fun deleteEjercicio(ejercicio: Ejercicio)





}