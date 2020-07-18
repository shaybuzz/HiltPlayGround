package com.tut.hiltplayground.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BlogsDao {
    @Query("SELECT * FROM blogs")
    suspend fun getBlogs():List<BlogCacheEntity>

    @Insert
    suspend fun upsert(blogCacheEntity: BlogCacheEntity):Long
}