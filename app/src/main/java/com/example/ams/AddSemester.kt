package com.example.ams

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.*

class AddSemester : AppCompatActivity() {
    lateinit var database: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_semester)


        val sem_year: EditText = findViewById(R.id.sem_year)
        val sem_subject: EditText = findViewById(R.id.sem_subject)
        val sem_classDay: EditText = findViewById(R.id.class_day)
        val sem_classTime: EditText = findViewById(R.id.class_time)
        val submit_semester: Button = findViewById(R.id.submit_semester)
        val returnToStartScreen: TextView = findViewById(R.id.return_to_startscreen)


        submit_semester.setOnClickListener{

            val semesterData = listOf(SemesterData(0,sem_year.text.toString(),sem_subject.text.toString(),sem_classDay.text.toString(),sem_classTime.text.toString()))
            database = DatabaseHelper.getDatabase(this)
            GlobalScope.launch {
                database.semesterDao().insertSemester(semesterData)
            }
            Toast.makeText(this, "semester successfully added for "+sem_subject.text.toString(), Toast.LENGTH_SHORT).show()

            sem_year.setText("")
            sem_subject.setText("")
            sem_classDay.setText("")
            sem_classTime.setText("")

        }

        returnToStartScreen.setOnClickListener{
            val intent = Intent(this,StartScreen::class.java)
            startActivity(intent)
            finish()
        }



    }
}