package com.tut.hiltplayground.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface BlogDao {
    @Query("SELECT * FROM blogs")
    suspend fun getBlogs():List<BlogCacheEntity>

    @Update
    suspend fun upsert(blogCacheEntity: BlogCacheEntity):Long
}