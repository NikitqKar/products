package com.bignerdranch.android.leagues

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api-football-standings.azharimm.site")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): LeaguesApi = retrofit.create(LeaguesApi::class.java)

    @Provides
    fun provideRepo(api: LeaguesApi) = LeagueRepository(api)
}