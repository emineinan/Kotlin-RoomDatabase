package com.example.kotlinroomdatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study")
data class Study(
    @PrimaryKey
    val tableId: String,

    @ColumnInfo(name = "course")
    val course: String,

    @ColumnInfo(name = "plan")
    val plan: String
) {
}