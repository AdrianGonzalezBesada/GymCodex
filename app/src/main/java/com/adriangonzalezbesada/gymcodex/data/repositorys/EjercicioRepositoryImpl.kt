package com.adriangonzalezbesada.gymcodex.data.repositorys

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.EjercicioDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EjercicioRepositoryImpl @Inject constructor(
    private val dao: EjercicioDao
) : IEjercicioRepository {

    override suspend fun getAllEjercicios(): Flow<List<Ejercicio>> {
        return dao.getAll()
    }

    override suspend fun getByNombreEjercicio(nombre_ejercicio: String): Flow<List<Ejercicio>> {
        return dao.getByNombreEjercicio(nombre_ejercicio)
    }

    override suspend fun getByTipoEntrenamiento(tipo_entrenamiento: String): Flow<List<Ejercicio>> {
        return dao.getByTipoEntrenamiento(tipo_entrenamiento)
    }

    override suspend fun insertEjercicio(ejercicio: Ejercicio) {
        dao.insertEjercicio(ejercicio)
    }

    override suspend fun insertEjercicios(ejercicios: List<Ejercicio>) {
        dao.insertEjercicios(ejercicios)
    }

    override suspend fun updateEjercicio(ejercicio: Ejercicio) {
        dao.updateEjercicio(ejercicio)
    }

    override suspend fun deleteEjercicio(ejercicio: Ejercicio) {
        dao.deleteEjercicio(ejercicio)
    }

    override suspend fun deleteAllEjercicios() {
        dao.deleteAllEjercicios()
    }
}