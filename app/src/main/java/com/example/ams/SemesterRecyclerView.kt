package com.example.ams

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//class SemesterRecyclerView: RecyclerView.Adapter<SemesterViewHolder> {
    class SemesterRecyclerView(val semester: List<SemesterData>, val context : Context) : RecyclerView.Adapter<SemesterRecyclerView.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.semester_item_view, parent, false)
            return MyViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.sem_no.text = (position+1).toString()
            holder.SemSession.text = semester[position].sem_session.toString()
            holder.semSubject.text = semester[position].sem_subject.toString()
            holder.semCard.setOnClickListener(){
                Toast.makeText(context, " Semester data ", Toast.LENGTH_SHORT).show()
                }

            holder.semClassDay.text = semester[position].sem_classDay.toString()
            holder.semClassTime.text = semester[position].sem_classTime.toString()


        }


        override fun getItemCount(): Int {
            return semester.size
        }

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var semCard = itemView.findViewById<CardView>(R.id.semesterCard)
            var sem_no = itemView.findViewById<TextView>(R.id.semesterNo)
            var semSubject = itemView.findViewById<TextView>(R.id.subject)
            var SemSession = itemView.findViewById<TextView>(R.id.semester_Year)
            var semClassDay = itemView.findViewById<TextView>(R.id.class_day)
            var semClassTime = itemView.findViewById<TextView>(R.id.class_time)

        }
    }