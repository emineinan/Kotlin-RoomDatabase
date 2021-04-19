package com.example.kotlinroomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinroomdatabase.adapter.StudyAdapter
import com.example.kotlinroomdatabase.database.Study
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var studyViewModel: StudyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Study Plan"

        val studyAdapter = StudyAdapter(this)
        recyclerView.adapter = studyAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        studyViewModel = ViewModelProvider(this).get(StudyViewModel::class.java)
        studyViewModel.allStudies.observe(this, Observer {
            it.let {
                studyAdapter.setBooks(it)
            }
        })
    }

    fun goToAdd(view: View) {
        val intent = Intent(this, StudyActivity::class.java)
        startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val id = UUID.randomUUID().toString()
            val course = data?.getStringExtra(StudyActivity.NEW_COURSE) ?: ""
            val plan = data?.getStringExtra(StudyActivity.NEW_PLAN) ?: ""

            val study=Study(id,course,plan)
            studyViewModel.insert(study)

            Toast.makeText(applicationContext, "New study plan added.", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "New study plan could not added.", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val NEW_NOTE_ACTIVITY_REQUEST_CODE = 1
    }
}