package com.example.kotlinroomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinroomdatabase.R
import com.example.kotlinroomdatabase.adapter.StudyAdapter.StudyViewHolder
import com.example.kotlinroomdatabase.database.Study
import kotlinx.android.synthetic.main.list_item.view.*

class StudyAdapter(private val context: Context) :
    RecyclerView.Adapter<StudyAdapter.StudyViewHolder>() {

    private var studyList: List<Study> = mutableListOf()

    class StudyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var pos = 0

        fun setData(course: String, plan: String, position: Int) {
            itemView.tvCourse.text = course
            itemView.tvStudyPlan.text = plan
            this.pos = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return StudyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studyList.size
    }

    override fun onBindViewHolder(holder: StudyViewHolder, position: Int) {
        val study = studyList[position]
        holder.setData(study.course, study.plan, position)
    }

    fun setBooks(studies: List<Study>) {
        studyList = studies
        notifyDataSetChanged()
    }
}