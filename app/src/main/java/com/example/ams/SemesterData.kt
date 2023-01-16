package com.example.ams

import androidx.room.*

@Entity(tableName = "tbl_semester")
data class SemesterData(
    @PrimaryKey(autoGenerate = true)
    val sem_id: Int,
    val sem_session: String?,
    val sem_subject: String?,
    val sem_classDay:String?,
    val sem_classTime: String?
)
