package com.example.kotlinroomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudyDao {
    @Insert
    fun insert(study: Study)

    @get:Query("SELECT * FROM study")
    val allStudies: LiveData<List<Study>>

    @Query("DELETE FROM study")
    fun deleteAllStudies()
}