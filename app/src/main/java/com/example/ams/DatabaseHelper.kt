package com.example.ams

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SemesterData::class], version = 1)
abstract class DatabaseHelper: RoomDatabase() {
    abstract fun semesterDao() : SemesterDao

    companion object{
        @Volatile
        private var INSTANCE : DatabaseHelper? = null
        fun getDatabase(context: Context):DatabaseHelper{
            if (INSTANCE == null)
            {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,DatabaseHelper::class.java,"AMS.db").build()
                }
            }
            return INSTANCE!!
        }
    }


}