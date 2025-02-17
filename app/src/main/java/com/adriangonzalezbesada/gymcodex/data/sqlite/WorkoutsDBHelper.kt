package com.adriangonzalezbesada.gymcodex.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class WorkoutsDBHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${GymCodexSQLiteContract.WorkoutEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_NAME} TEXT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_TYPE} TEXT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_WEIGHT_1} INT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_REPS_1} INT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_WEIGHT_2} INT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_REPS_2} INT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_WEIGHT_3} INT," +
                "${GymCodexSQLiteContract.WorkoutEntry.COLUMN_NAME_WORKOUT_REPS_3} INT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${GymCodexSQLiteContract.WorkoutEntry.TABLE_NAME}"


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }


    companion object {
        private val DATABASE_NAME = "GymCodexSQLite.db"
        private val DATABASE_VERSION = 1
    }
}