package com.tcnhong.hawkout.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM Exercise")
    fun getAll(): List<Exercise>
}