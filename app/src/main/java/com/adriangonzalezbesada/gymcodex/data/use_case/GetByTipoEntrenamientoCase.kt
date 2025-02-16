package com.adriangonzalezbesada.gymcodex.data.use_case

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetByTipoEntrenamientoCase @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) {

    suspend fun execute(tipoEntrenamiento: String): Flow<List<Ejercicio>> = withContext(Dispatchers.IO){

        ejercicioRepositoryImpl.getByTipoEntrenamiento(tipoEntrenamiento)
    }

}