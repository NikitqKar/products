package com.bignerdranch.android.leagues

import retrofit2.http.GET

interface LeaguesApi {

    @GET("leagues")
    suspend fun getLeague(): Leagues
}