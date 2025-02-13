package com.adriangonzalezbesada.gymcodex

import android.content.ComponentCallbacks2
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.room.Room
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.GymCodexDatabase
import com.adriangonzalezbesada.gymcodex.data.repositorys.EjercicioRepositoryImpl
import com.adriangonzalezbesada.gymcodex.ui.viewmodels.EntrenamientosViewModel
import com.adriangonzalezbesada.gymcodex.ui.viewmodels.EntrenamientosViewModelFactory
import com.adriangonzalezbesada.gymcodex.ui.views.EntrenamientosView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import java.time.ZonedDateTime

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var db: GymCodexDatabase
    lateinit var ejercicioRepository: EjercicioRepositoryImpl

    val entrenamientosViewModel: EntrenamientosViewModel by viewModels {
        EntrenamientosViewModelFactory(ejercicioRepository)
    }

//    Esto es lo único que debería de necesitarse mediante Hilt, sin inicializaciones ni parámetro a la vista
//    private val entrenamientosViewModel: EntrenamientosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        db = Room.databaseBuilder(
                applicationContext,
        GymCodexDatabase::class.java, "GymCodexDatabase"
        ).fallbackToDestructiveMigration().build()

        ejercicioRepository = EjercicioRepositoryImpl(db.ejercicioDao())

        entrenamientosViewModel.deleteAllEjercicios()

        entrenamientosViewModel.insertEjercicios(

            mutableListOf(
                Ejercicio(0,"Sentadilla", fecha_creacion = ZonedDateTime.now()),
                Ejercicio(0,"Press de banca", fecha_creacion = ZonedDateTime.now()),
                Ejercicio(0,"Gemelo", fecha_creacion = ZonedDateTime.now())
            )
        )


        setContent {
            EntrenamientosView(entrenamientosViewModel)
//            EntrenamientosView()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "Aplicación abierta")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "Aplicación minimizada")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "Aplicación restaurada")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "Aplicación cerrada")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("ActivityLifecycle", "Rotación de pantalla")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level == ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            Log.d("MemoryStatus", "Poca memoria disponible")
        }
    }
}

