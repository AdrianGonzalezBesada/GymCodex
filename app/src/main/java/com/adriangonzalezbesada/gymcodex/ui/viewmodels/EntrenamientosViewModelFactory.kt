package com.adriangonzalezbesada.gymcodex.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl

class EntrenamientosViewModelFactory(
    private val repository: EjercicioRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EntrenamientosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EntrenamientosViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase ViewModel desconocida")
    }
}
