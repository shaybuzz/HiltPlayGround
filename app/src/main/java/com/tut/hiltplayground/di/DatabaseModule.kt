package com.tut.hiltplayground.di

import android.content.Context
import androidx.room.Room
import com.tut.hiltplayground.local.BlogsDao
import com.tut.hiltplayground.local.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun providesBlogDB(@ApplicationContext context: Context):BlogDatabase{
        return Room.databaseBuilder(context, BlogDatabase::class.java, "blogs_db").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providesBlogDao(db:BlogDatabase): BlogsDao {
        return db.getBlogsDao()
    }


}