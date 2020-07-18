package com.tut.hiltplayground.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BlogsDao {
    @Query("SELECT * FROM blogs")
    suspend fun getBlogs():List<BlogCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(blogCacheEntity: BlogCacheEntity):Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(blogs:List<BlogCacheEntity>)
}