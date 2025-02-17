package com.adriangonzalezbesada.gymcodex.domain.use_case

import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteAllEjerciciosCase @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) {

    suspend fun execute() = withContext(Dispatchers.IO){

            ejercicioRepositoryImpl.deleteAllEjercicios()
    }

}