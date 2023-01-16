package com.example.ams

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SemesterList : AppCompatActivity() {
    lateinit var database:DatabaseHelper
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semester)
        val semesterList = findViewById<RecyclerView>(R.id.semester_list)

        database = DatabaseHelper.getDatabase(this)
        database.semesterDao().getSemester().observe(this, Observer {

            semesterList.adapter = SemesterRecyclerView(it, this)
            semesterList.layoutManager = LinearLayoutManager(this)


        })
    }
}