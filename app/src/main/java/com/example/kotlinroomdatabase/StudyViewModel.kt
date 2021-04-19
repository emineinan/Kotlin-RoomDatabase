package com.example.kotlinroomdatabase

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinroomdatabase.database.Study
import com.example.kotlinroomdatabase.database.StudyDao
import com.example.kotlinroomdatabase.database.StudyRoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class StudyViewModel(application: Application) : AndroidViewModel(application) {
    private var studyDao: StudyDao
    val allStudies: LiveData<List<Study>>

    init {
        val studyDb = StudyRoomDatabase.getDatabase(application)
        studyDao = studyDb!!.stydyDao()
        allStudies = studyDao.allStudies
    }

    fun insert(study: Study) {
        GlobalScope.async {
            studyDao.insert(study)
        }
    }

    fun deleteAll() {
        GlobalScope.async {
            studyDao.deleteAllStudies()
        }
    }

    companion object {
        private class InsertAsyncTask(private val studyDao: StudyDao) :
            AsyncTask<Study, Void, Void?>() {
            override fun doInBackground(vararg studies: Study): Void? {
                studyDao.insert(studies[0])
                return null
            }
        }
    }
}