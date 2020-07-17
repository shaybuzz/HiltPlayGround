package com.tut.hiltplayground.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BlogNetworkEntity(
    @Expose
    val pk: Int,
    @Expose
    val body: String,
    @Expose
    val category: String,
    @Expose
    val image: String,
    @Expose
    val title: String
) : Serializable