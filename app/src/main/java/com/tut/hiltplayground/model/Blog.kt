package com.tut.hiltplayground.model

import java.io.Serializable

data class Blog(
    val id: Int,
    val body: String,
    val category: String,
    val image: String,
    val title: String
) : Serializable