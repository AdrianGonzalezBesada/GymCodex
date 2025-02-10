package com.adriangonzalezbesada.gymcodex.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
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
import java.time.ZonedDateTime

@Composable
fun EntrenamientosView(entrenamientosViewModel: EntrenamientosViewModel) {

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
        modifier = Modifier.drawBehind {
            drawLine(
                color = Color.Black,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = 2.dp.toPx()
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

@Composable
fun MainContent(modifier: Modifier = Modifier, entrenamientosViewModel: EntrenamientosViewModel) {


    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Esta es una aplicación para tomar registro y hacer un seguimiento de los levantamientos.",
            modifier = Modifier
                .padding(vertical = 50.dp)
                .padding(horizontal = 10.dp)
        )

        RepeaterGridsEjercicios(entrenamientosViewModel)
    }
}

@Composable
fun RepeaterGridsEjercicios(entrenamientosViewModel: EntrenamientosViewModel) {

    val allEjercicios by entrenamientosViewModel.allEjercicios.collectAsState(initial = emptyList<Ejercicio>())

    val listasPorEjercicio: List<List<Ejercicio>> =
        allEjercicios.toList().groupBy { it.nombre_ejercicio }.values.toList()

    for (listaPorEjercicio in listasPorEjercicio) {

        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 45.dp).padding(horizontal = 15.dp)) {
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

            var peso1Usuario by remember { mutableStateOf("") }
            var reps1Usuario by remember { mutableStateOf("") }
            var peso2Usuario by remember { mutableStateOf("") }
            var reps2Usuario by remember { mutableStateOf("") }
            var peso3Usuario by remember { mutableStateOf("") }
            var reps3Usuario by remember { mutableStateOf("") }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = peso1Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        peso1Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = reps1Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        reps1Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = peso2Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        peso2Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = reps2Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        reps2Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = peso3Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        peso3Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = reps3Usuario,
                    onValueChange = { newValue ->
                        val onlyNumber = newValue.filter { it.isDigit() }
                        reps3Usuario = onlyNumber },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 2,
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(onClick = { entrenamientosViewModel.insertEjercicio(
                    Ejercicio(
                        0,
                        listaPorEjercicio[0].nombre_ejercicio,
                        "brazo",
                        peso1Usuario.toIntOrNull(),
                        reps1Usuario.toIntOrNull(),
                        peso2Usuario.toIntOrNull(),
                        reps2Usuario.toIntOrNull(),
                        peso3Usuario.toIntOrNull(),
                        reps3Usuario.toIntOrNull(),
                        ZonedDateTime.now()
                        )) }
                ) {
                    Text("+")
                }
            }
        }
    }
}

fun addEntrenamiento() {

}