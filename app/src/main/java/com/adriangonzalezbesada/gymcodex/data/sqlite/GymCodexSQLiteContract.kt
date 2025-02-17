package com.adriangonzalezbesada.gymcodex.data.sqlite

import android.provider.BaseColumns

object GymCodexSQLiteContract {

    object WorkoutEntry : BaseColumns {
        const val TABLE_NAME = "workouts"
        const val COLUMN_NAME_WORKOUT_NAME = "workout_name"
        const val COLUMN_NAME_WORKOUT_TYPE = "workout_type"
        const val COLUMN_NAME_WORKOUT_WEIGHT_1 = "workout_weight_1"
        const val COLUMN_NAME_WORKOUT_REPS_1 = "workout_reps_1"
        const val COLUMN_NAME_WORKOUT_WEIGHT_2 = "workout_weight_2"
        const val COLUMN_NAME_WORKOUT_REPS_2 = "workout_reps_2"
        const val COLUMN_NAME_WORKOUT_WEIGHT_3 = "workout_weight_3"
        const val COLUMN_NAME_WORKOUT_REPS_3 = "workout_reps_3"
    }

}