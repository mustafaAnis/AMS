package com.example.ams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)
        var addSemester: Button?
        var semesterList: Button?

        addSemester = findViewById(R.id.add_semester)
        semesterList = findViewById(R.id.semester_list)


        addSemester.setOnClickListener {
            val intent = Intent(this, AddSemester::class.java)
            startActivity(intent)
            finish()
        }
        semesterList.setOnClickListener {
            val intent = Intent(this, SemesterList::class.java)
            startActivity(intent)
            finish()

        }
    }
}