package com.tcnhong.hawkout.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "nameKr") val nameKr: String?,
    @ColumnInfo(name = "nameEng") val nameEng: String?,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "force") val force: String?,
    @ColumnInfo(name = "preparation") val preparation: String?,
    @ColumnInfo(name = "execution") val execution: String?,
    @ColumnInfo(name = "comment") val comment: String?,
    @ColumnInfo(name = "target") val target: String?,
    @ColumnInfo(name = "synergists") val synergists: String?,
    @ColumnInfo(name = "dynamicStabilizer") val dynamicStabilizer: String?,
    @ColumnInfo(name = "item") val item: String?
)
