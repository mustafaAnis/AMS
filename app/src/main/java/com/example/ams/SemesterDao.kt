package com.example.ams

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select


@Dao
interface SemesterDao {

    @Insert
    suspend fun insertSemester(semesterData: List<SemesterData>)

    @Query("select * from tbl_semester;")
    fun getSemester(): LiveData<List<SemesterData>>

}