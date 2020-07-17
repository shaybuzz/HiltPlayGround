package com.tut.hiltplayground.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "blogs")
data class BlogCacheEntity(
    @PrimaryKey
    val id: Int,
    val body: String,
    val category: String,
    val image: String,
    val title: String
) : Serializable