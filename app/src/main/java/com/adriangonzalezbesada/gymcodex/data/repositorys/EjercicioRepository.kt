package com.adriangonzalezbesada.gymcodex.data.repositorys

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.EjercicioDao
import kotlinx.coroutines.flow.Flow

class EjercicioRepository(private val dao: EjercicioDao) {

    val allEjercicios: Flow<List<Ejercicio>> = dao.getAll()

    suspend fun getByNombreEjercicio(nombre_ejercicio: String): Flow<List<Ejercicio>> {
        return dao.getByNombreEjercicio(nombre_ejercicio)
    }

    suspend fun getByTipoEntrenamiento(tipo_entrenamiento: String): Flow<List<Ejercicio>> {
        return dao.getByTipoEntrenamiento(tipo_entrenamiento)
    }

    suspend fun insertEjercicio(training: Ejercicio) {
        dao.insertEjercicio(training)
    }

    suspend fun insertEjercicios(ejercicios: List<Ejercicio>) {
        dao.insertEjercicios(ejercicios)
    }

    suspend fun updateEjercicio(ejercicio: Ejercicio) {
        dao.updateEjercicio(ejercicio)
    }

    suspend fun deleteEjercicio(ejercicio: Ejercicio) {
        dao.deleteEjercicio(ejercicio)
    }

    suspend fun deleteAllEjercicios() {
        dao.deleteAllEjercicios()
    }
}