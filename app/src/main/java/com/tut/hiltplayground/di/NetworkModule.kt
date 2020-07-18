package com.tut.hiltplayground.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tut.hiltplayground.network.BlogsApi
import com.tut.hiltplayground.view.BlogApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    private val BASE_UTL = "https://open-api.xyz/"

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun providesGsonFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_UTL).addConverterFactory(gsonConverterFactory)
    }

    @Singleton
    @Provides
    fun getBlogApi(retrofit: Retrofit.Builder):BlogsApi{
        return retrofit.build().create(BlogsApi::class.java)
    }

}