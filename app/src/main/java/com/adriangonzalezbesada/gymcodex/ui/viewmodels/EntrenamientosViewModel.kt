package com.adriangonzalezbesada.gymcodex.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.domain.use_case.DeleteAllEjerciciosCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.DeleteEjercicioCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.GetAllEjerciciosCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.GetByNombreEjercicioCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.GetByTipoEntrenamientoCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.GetLastCommitInfoCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.InsertEjercicioCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.InsertEjerciciosCase
import com.adriangonzalezbesada.gymcodex.domain.use_case.UpdateEjercicioCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntrenamientosViewModel @Inject constructor(
    private val getAllEjerciciosCase: GetAllEjerciciosCase,
    private val getByNombreEjercicioCase: GetByNombreEjercicioCase,
    private val getByTipoEntrenamientoCase: GetByTipoEntrenamientoCase,
    private val insertEjercicioCase: InsertEjercicioCase,
    private val insertEjerciciosCase: InsertEjerciciosCase,
    private val updateEjercicioCase: UpdateEjercicioCase,
    private val deleteEjercicioCase: DeleteEjercicioCase,
    private val deleteAllEjerciciosCase: DeleteAllEjerciciosCase,
    private val getLastCommitInfoCase: GetLastCommitInfoCase
) : ViewModel() {

    // PROPIEDADES OBSERVABLES

    private val _ultimoCommit = MutableStateFlow("")
    val ultimoCommit: StateFlow<String> = _ultimoCommit

    private val _allEjercicios = MutableStateFlow<List<Ejercicio>>(emptyList())
    val allEjercicios: StateFlow<List<Ejercicio>> get() = _allEjercicios

    private val _ejerciciosByNombreEjercicio = MutableStateFlow<List<Ejercicio>>(emptyList())
    val ejerciciosByNombreEjercicio: StateFlow<List<Ejercicio>> get() = _ejerciciosByNombreEjercicio

    private val _ejerciciosByTipoEntrenamiento = MutableStateFlow<List<Ejercicio>>(emptyList())
    val ejerciciosByTipoEntrenamiento: StateFlow<List<Ejercicio>> get() = _ejerciciosByTipoEntrenamiento


    // FUNCIONES

    suspend fun getAllEjercicios() = viewModelScope.launch(Dispatchers.IO){
        getAllEjerciciosCase.execute().collect { lista ->
            _allEjercicios.value = lista
        }
    }

    suspend fun getByNombreEjercicio(nombreEjercicio: String) = viewModelScope.launch(Dispatchers.IO){
        getByNombreEjercicioCase.execute(nombreEjercicio).collect { lista ->
            _ejerciciosByNombreEjercicio.value = lista
        }
    }

    suspend fun getByTipoEntrenamiento(tipoEntrenamiento: String) = viewModelScope.launch(Dispatchers.IO){
        getByTipoEntrenamientoCase.execute(tipoEntrenamiento).collect { lista ->
            _ejerciciosByTipoEntrenamiento.value = lista
        }
    }

    fun insertEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        insertEjercicioCase.execute(ejercicio)
    }

    fun insertEjercicios(ejercicios: List<Ejercicio>) = viewModelScope.launch(Dispatchers.IO) {
        insertEjerciciosCase.execute(ejercicios)
    }

    fun updateEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        updateEjercicioCase.execute(ejercicio)
    }

    fun deleteEjercicio(ejercicio: Ejercicio) = viewModelScope.launch(Dispatchers.IO) {
        deleteEjercicioCase.execute(ejercicio)
    }

    fun deleteAllEjercicios() = viewModelScope.launch(Dispatchers.IO) {
        deleteAllEjerciciosCase.execute()
    }

    fun getLastCommitInfo() = viewModelScope.launch(Dispatchers.IO) {

            val response = getLastCommitInfoCase.execute()
            if (response.isSuccessful) {
                _ultimoCommit.value = response.body()?.commit?.message ?: ""
            }
    }


}