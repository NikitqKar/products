package com.bignerdranch.android.leagues.app

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.leagues.data.database.LeagueDatabase
import com.bignerdranch.android.leagues.data.database.LeagueDao
import com.bignerdranch.android.leagues.data.web.LeagueRepository
import com.bignerdranch.android.leagues.data.web.LeaguesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api-football-standings.azharimm.site")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): LeaguesApi = retrofit.create(LeaguesApi::class.java)

    @Provides
    @Singleton
    fun provideRepo(api: LeaguesApi, dao: LeagueDao): LeagueRepository = LeagueRepository(api, dao)

    @Provides
    @Singleton
    fun provideLeagueDao(leagueDatabase: LeagueDatabase): LeagueDao = leagueDatabase.leagueDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): LeagueDatabase = Room.databaseBuilder(
        appContext, LeagueDatabase::class.java, "LeaguesDatabase"
    ).build()
}