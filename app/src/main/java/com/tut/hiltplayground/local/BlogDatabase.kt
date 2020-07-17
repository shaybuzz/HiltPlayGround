package com.tut.hiltplayground.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class], version = 1, exportSchema = false)
abstract class BlogDatabase: RoomDatabase() {

    abstract fun getBlogDao():BlogDao

    companion object{
        @Volatile
        private var INSTANCE:BlogDatabase? = null

        fun getInstance(context: Context):BlogDatabase{
            val db = INSTANCE
            if(db != null) return db
            synchronized(this){
                val db = INSTANCE
                if(db == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, BlogDatabase::class.java, "blogs_db").build()
                }
                return INSTANCE!!
            }
        }
    }



}