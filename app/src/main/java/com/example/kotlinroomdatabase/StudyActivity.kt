package com.example.kotlinroomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)
        title="New Study Plan"
    }

    fun add(view: View) {
        var intent = Intent()
        if (etCourse.text.isEmpty() || etStudyPlan.text.isEmpty()) {
            Toast.makeText(this, "Please enter necessary fields!", Toast.LENGTH_SHORT).show()
        } else {
            val course = etCourse.text.toString()
            val studyPlan = etStudyPlan.text.toString()

            intent.putExtra(NEW_COURSE, course)
            intent.putExtra(NEW_PLAN, studyPlan)
            setResult(Activity.RESULT_OK, intent)
        }
        finish()
    }

    companion object {
        const val NEW_COURSE = "new_course"
        const val NEW_PLAN = "new_plan"
    }
}