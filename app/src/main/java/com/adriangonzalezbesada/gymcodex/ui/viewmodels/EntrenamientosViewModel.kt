package com.adriangonzalezbesada.gymcodex.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class EntrenamientosViewModel @Inject constructor(
    private val ejercicioRepositoryImpl: EjercicioRepositoryImpl
) : ViewModel() {

    val allEjercicios: Flow<List<Ejercicio>> = ejercicioRepositoryImpl.allEjercicios

    fun insertEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepositoryImpl.insertEjercicio(ejercicio)
    }

    fun insertEjercicios(ejercicios: List<Ejercicio>) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepositoryImpl.insertEjercicios(ejercicios)
    }

    fun updateEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepositoryImpl.updateEjercicio(ejercicio)
    }

    fun deleteEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepositoryImpl.deleteEjercicio(ejercicio)
    }

    fun deleteAllEjercicios() = viewModelScope.launch(Dispatchers.IO) {
        ejercicioRepositoryImpl.deleteAllEjercicios()
    }
}