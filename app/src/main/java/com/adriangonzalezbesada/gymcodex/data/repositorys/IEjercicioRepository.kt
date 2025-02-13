package com.adriangonzalezbesada.gymcodex.data.repositorys

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import kotlinx.coroutines.flow.Flow

interface IEjercicioRepository {

    val allEjercicios: Flow<List<Ejercicio>>

    suspend fun getByNombreEjercicio(nombre_ejercicio: String): Flow<List<Ejercicio>>

    suspend fun getByTipoEntrenamiento(tipo_entrenamiento: String): Flow<List<Ejercicio>>

    suspend fun insertEjercicio(training: Ejercicio)

    suspend fun insertEjercicios(ejercicios: List<Ejercicio>)

    suspend fun updateEjercicio(ejercicio: Ejercicio)

    suspend fun deleteEjercicio(ejercicio: Ejercicio)

    suspend fun deleteAllEjercicios()
}