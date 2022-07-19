package com.bignerdranch.android.leagues

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val leagues = MutableLiveData(listOf<League>())

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api-football-standings.azharimm.site")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(LeaguesApi::class.java)

    fun update(){
        api.getLeague().enqueue(object : Callback<Leagues> {
            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                leagues.value = response.body()?.data ?: emptyList()
            }

            override fun onFailure(call: Call<Leagues>, t: Throwable) {
                Log.e("MainViewModel", "Call Failed", t)
            }
        })
    }
}