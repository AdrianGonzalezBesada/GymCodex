package com.adriangonzalezbesada.gymcodex.domain.use_case

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetByNombreEjercicioCase @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) {

    suspend fun execute(nombreEjercicio: String): Flow<List<Ejercicio>> = withContext(Dispatchers.IO) {

        ejercicioRepositoryImpl.getByNombreEjercicio(nombreEjercicio)

    }

}