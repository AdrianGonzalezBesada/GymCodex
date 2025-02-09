package com.adriangonzalezbesada.gymcodex.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.adriangonzalezbesada.gymcodex.R
import com.adriangonzalezbesada.gymcodex.data.Ejercicio
import com.adriangonzalezbesada.gymcodex.data.EjercicioDao
import com.adriangonzalezbesada.gymcodex.data.GymCodexDatabase
import com.adriangonzalezbesada.gymcodex.ui.theme.GymCodexTheme
import com.adriangonzalezbesada.gymcodex.ui.viewmodels.EntrenamientosViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList

@Composable
fun EntrenamientosView(entrenamientosViewModel: EntrenamientosViewModel) {
//fun EntrenamientosView(ejercicioDao: EjercicioDao) {

    GymCodexTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar() }
        ) { innerPadding ->

            MainContent(
                modifier = Modifier
                    .padding(innerPadding),
                entrenamientosViewModel = entrenamientosViewModel
            )
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    CenterAlignedTopAppBar(
        modifier = Modifier,
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
    Divider(color = Color.Black, thickness = 1.dp)
}

@Composable
fun MainContent(modifier: Modifier = Modifier, entrenamientosViewModel: EntrenamientosViewModel) {
//fun MainContent(modifier: Modifier = Modifier, ejercicioDao: EjercicioDao) {


//    val allEjercicios = ejercicioDao.getAll()
    val allEjercicios by entrenamientosViewModel.allEjercicios.collectAsState(initial = emptyList<Ejercicio>())

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

        RepeaterGridsEjercicios(allEjercicios)
    }
}

@Composable
fun RepeaterGridsEjercicios(ejercicios: List<Ejercicio>) {

    val listasPorEjercicio: List<List<Ejercicio>> =
        ejercicios.toList().groupBy { it.nombre_ejercicio }.values.toList()

    for (listaPorEjercicio in listasPorEjercicio) {

        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 35.dp).padding(horizontal = 30.dp)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("${listaPorEjercicio[0].nombre_ejercicio}")
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
                    Text("${ejercicio.peso_1}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps_1}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.peso_2}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps_2}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.peso_3}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${ejercicio.reps_3}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }
            }
        }
    }
}