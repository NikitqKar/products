package com.bignerdranch.android.leagues.data.web

import com.bignerdranch.android.leagues.data.entity.Leagues
import retrofit2.http.GET

interface LeaguesApi {
    @GET("leagues")
    suspend fun getLeague(): Leagues
}