package com.bignerdranch.android.leagues

import androidx.lifecycle.LiveData
import com.bignerdranch.android.leagues.League
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface LeaguesApi {
    @GET("leagues")
    fun getLeague(): Call<Leagues>
}