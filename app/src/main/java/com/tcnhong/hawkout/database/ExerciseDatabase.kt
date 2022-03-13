package com.tcnhong.hawkout.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Exercise::class], version = 1)
abstract class ExerciseDatabase: RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao

    companion object {
        private var instance: ExerciseDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ExerciseDatabase? {
            if (instance == null) {
                synchronized(ExerciseDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExerciseDatabase::class.java,
                        "Exercise"
                    )
                        .createFromAsset("db.db")
                        .build()
                }
            }
            return instance
        }
    }
}