package com.adriangonzalezbesada.gymcodex.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "ejercicios")
data class Ejercicio(
    @PrimaryKey(autoGenerate = true) val id_ejercicio: Int = 0,
    @ColumnInfo(name = "nombre_ejercicio") val nombre_ejercicio: String? = "",
    @ColumnInfo(name = "tipo_entrenamiento") val tipo_entrenamiento: String = "",
    @ColumnInfo(name = "peso_1") val peso_1: Int? = 0,
    @ColumnInfo(name = "reps_1") val reps_1: Int? = 0,
    @ColumnInfo(name = "peso_2") val peso_2: Int? = 0,
    @ColumnInfo(name = "reps_2") val reps_2: Int? = 0,
    @ColumnInfo(name = "peso_3") val peso_3: Int? = 0,
    @ColumnInfo(name = "reps_3") val reps_3: Int? = 0,
    @ColumnInfo(name = "fecha_creacion") val fecha_creacion: ZonedDateTime? = null
)

