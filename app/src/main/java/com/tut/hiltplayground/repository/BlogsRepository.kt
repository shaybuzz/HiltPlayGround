package com.tut.hiltplayground.repository

import com.tut.hiltplayground.local.BlogsDao
import com.tut.hiltplayground.local.CacheEntityMapper
import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.network.BlogsApi
import com.tut.hiltplayground.network.NetworkMapper
import com.tut.hiltplayground.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogsRepository(
    private val blogsApi: BlogsApi,
    private val blogsDao: BlogsDao,
    private val networkMapper: NetworkMapper,
    private val cacheEntityMapper: CacheEntityMapper
) {

    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogsApi.getBlogs()
            val blogs = networkMapper.toBlogs(networkBlogs)
            blogsDao.upsert(blogs.map {
                cacheEntityMapper.fromDomainModel(it)
            })
//            blogs.forEach {
//                blogsDao.upsert(cacheEntityMapper.fromDomainModel(it))
//            }
            emit(DataState.Success(cacheEntityMapper.toBlogs(blogsDao.getBlogs())))
        } catch (exception: Exception) {
            emit(DataState.Error(exception))
        }
    }


}