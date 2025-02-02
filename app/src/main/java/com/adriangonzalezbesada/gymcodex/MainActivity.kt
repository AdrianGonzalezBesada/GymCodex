package com.adriangonzalezbesada.gymcodex

import android.content.ComponentCallbacks2
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.EjercicioMock
import com.adriangonzalezbesada.gymcodex.data.MockExercisesList
import com.adriangonzalezbesada.gymcodex.ui.theme.GymCodexTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymCodexTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() }
                ) { innerPadding ->

                    MainContent(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
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

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    CenterAlignedTopAppBar(
        modifier = Modifier.drawBehind {
            drawLine(
                color = Color.Black,
                start = Offset(0f, size.height - 1f),
                end = Offset(size.width, size.height - 1f),
                strokeWidth = 5f
            )
        },
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(id = R.drawable.ic_dumbbell),
                    contentDescription = "Mancuerna",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(MaterialTheme.typography.titleLarge.fontSize.value.dp)
                )
                Text("GymCodex")
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Futuro dropdown */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Mancuerna")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainContent(modifier: Modifier = Modifier) {

    val listaEjercicios: List<EjercicioMock> = MockExercisesList.exercisesList

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Esta es una aplicación para tomar registro y hacer un seguimiento de los levantamientos.",
            modifier = Modifier
                .padding(vertical = 50.dp)
                .padding(horizontal = 10.dp)
        )

        RepeaterGridsEjercicios(listaEjercicios)
    }
}


@Composable
fun RepeaterGridsEjercicios(ejercicios: List<EjercicioMock>) {

    val listasPorEjercicio: List<List<EjercicioMock>> =
        ejercicios.groupBy { it.ejercicio }.values.toList();

    for (listaPorEjercicio in listasPorEjercicio) {

        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 35.dp).padding(horizontal = 30.dp)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(listaPorEjercicio[0].ejercicio)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Peso 1", modifier = Modifier.weight(1f))
                Text("Reps 1", modifier = Modifier.weight(1f))
                Text("Peso 2", modifier = Modifier.weight(1f))
                Text("Reps 2", modifier = Modifier.weight(1f))
                Text("Peso 3", modifier = Modifier.weight(1f))
                Text("Reps 3", modifier = Modifier.weight(1f))
            }

            for (ejercicio in listaPorEjercicio) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("${ejercicio.peso1}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps1}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.peso2}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps2}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.peso3}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps3}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }
            }
        }
    }
}