package com.adriangonzalezbesada.gymcodex.data.use_case

import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertEjerciciosCase @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) {

    suspend fun execute(ejercicios: List<Ejercicio>) = withContext(Dispatchers.IO){

            ejercicioRepositoryImpl.insertEjercicios(ejercicios)
    }

}