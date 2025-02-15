package com.adriangonzalezbesada.gymcodex.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.LastCommitResponse
import com.adriangonzalezbesada.gymcodex.data.RetrofitInstance
import com.adriangonzalezbesada.gymcodex.data.repositorys.CommitAPIImpl
import com.adriangonzalezbesada.gymcodex.data.repositorys.IEjercicioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class EntrenamientosViewModel @Inject constructor(
    private val ejercicioRepositoryImpl: IEjercicioRepository,
    private val commitAPIImpl: CommitAPIImpl
) : ViewModel() {

    private val _ultimoCommit = MutableStateFlow("")
    val ultimoCommit: StateFlow<String> = _ultimoCommit

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

    fun getLastCommitInfo() {

        viewModelScope.launch(Dispatchers.IO) {
            val response = commitAPIImpl.getLastCommitInfo()
            if (response.isSuccessful) {
                _ultimoCommit.value = response.body()?.commit?.message ?: ""
            }
        }
    }


}