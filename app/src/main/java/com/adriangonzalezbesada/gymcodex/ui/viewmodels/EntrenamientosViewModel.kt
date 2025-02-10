package com.adriangonzalezbesada.gymcodex.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class EntrenamientosViewModel(private val ejercicioRepository: EjercicioRepository) : ViewModel() {

    val allEjercicios: Flow<List<Ejercicio>> = ejercicioRepository.allEjercicios

    fun insertEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepository.insertEjercicio(ejercicio)
    }

    fun insertEjercicios(ejercicios: List<Ejercicio>) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepository.insertEjercicios(ejercicios)
    }

    fun updateEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepository.updateEjercicio(ejercicio)
    }

    fun deleteEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepository.deleteEjercicio(ejercicio)
    }

    fun deleteAllEjercicios() = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepository.deleteAllEjercicios()
    }
}