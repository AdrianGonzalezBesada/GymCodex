package com.adriangonzalezbesada.gymcodex.data

import java.time.ZonedDateTime

data class Ejercicio(
    val ejercicio: String,
    val tipo: String = "",
    val peso1: Int = 0,
    val reps1: Int = 0,
    val peso2: Int = 0,
    val reps2: Int = 0,
    val peso3: Int = 0,
    val reps3: Int = 0,
    val fechaCreacion: ZonedDateTime? = null
)

object MockExercisesList {
    val exercisesList = listOf(
        Ejercicio("Press banca"),
        Ejercicio("Press banca", peso1 = 50),
        Ejercicio("Sentadilla libre"),
        Ejercicio("Sentadilla libre", peso1 = 70),
        Ejercicio("Peso muerto"),
        Ejercicio("Curl de bíceps")
    )
}

