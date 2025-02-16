package com.adriangonzalezbesada.gymcodex.data.use_case

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateEjercicioCase @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) {

    suspend fun execute(ejercicio: Ejercicio) = withContext(Dispatchers.IO){

            ejercicioRepositoryImpl.updateEjercicio(ejercicio)
    }

}