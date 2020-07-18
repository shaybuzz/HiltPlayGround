package com.tut.hiltplayground.utils

sealed class DataState<out T> {
    data class Success<R>(val data: R) : DataState<R>()
    data class Error(val exception: Exception?) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}