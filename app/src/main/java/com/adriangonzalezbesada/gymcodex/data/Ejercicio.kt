package com.adriangonzalezbesada.gymcodex.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "ejercicios")
data class Ejercicio(
    @PrimaryKey val id_ejercicio: Int,
    @ColumnInfo(name = "nombre_ejercicio") val nombre_ejercicio: String?,
    @ColumnInfo(name = "categoria") val categoria: String?,
    @ColumnInfo(name = "peso_1") val peso_1: Int?,
    @ColumnInfo(name = "reps_1") val reps_1: Int?,
    @ColumnInfo(name = "peso_2") val peso_2: Int?,
    @ColumnInfo(name = "reps_2") val reps_2: Int?,
    @ColumnInfo(name = "peso_3") val peso_3: Int?,
    @ColumnInfo(name = "reps_3") val reps_3: Int?,
    @ColumnInfo(name = "fecha_creacion") val fecha_creacion: ZonedDateTime?
)

data class EjercicioMock(
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
        EjercicioMock("Press banca"),
        EjercicioMock("Press banca", peso1 = 50),
        EjercicioMock("Sentadilla libre"),
        EjercicioMock("Sentadilla libre", peso1 = 70),
        EjercicioMock("Peso muerto"),
        EjercicioMock("Curl de bíceps")
    )
}

