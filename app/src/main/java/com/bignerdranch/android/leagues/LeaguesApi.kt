package com.bignerdranch.android.leagues

import androidx.lifecycle.LiveData
import com.bignerdranch.android.leagues.League
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface LeaguesApi {
    @GET("leagues")
    fun getLeague(): Call<Leagues>
}