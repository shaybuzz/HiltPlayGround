package com.tut.hiltplayground.di

import com.tut.hiltplayground.local.BlogsDao
import com.tut.hiltplayground.local.CacheEntityMapper
import com.tut.hiltplayground.network.BlogsApi
import com.tut.hiltplayground.network.NetworkMapper
import com.tut.hiltplayground.repository.BlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun providesRepository(
        blogsApi: BlogsApi,
        blogsDao: BlogsDao,
        networkMapper: NetworkMapper,
        cacheEntityMapper: CacheEntityMapper
    ): BlogsRepository {
        return BlogsRepository(blogsApi, blogsDao, networkMapper, cacheEntityMapper)
    }
}