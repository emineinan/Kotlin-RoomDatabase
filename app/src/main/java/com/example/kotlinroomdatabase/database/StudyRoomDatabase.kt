package com.example.kotlinroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Study::class], version = 1)
abstract class StudyRoomDatabase : RoomDatabase() {
    abstract fun stydyDao(): StudyDao

    companion object {
        private var studyRoomInstance: StudyRoomDatabase? = null

        fun getDatabase(context: Context): StudyRoomDatabase? {
            if (studyRoomInstance == null) {
                synchronized(StudyRoomDatabase::class.java) {
                    studyRoomInstance = Room.databaseBuilder(
                        context.applicationContext,
                        StudyRoomDatabase::class.java,
                        "study_database"
                    ).build()
                }
            }
            return studyRoomInstance
        }
    }
}