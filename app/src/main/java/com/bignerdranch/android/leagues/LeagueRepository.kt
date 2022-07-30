package com.bignerdranch.android.leagues

import android.util.Log
import retrofit2.*

class LeagueRepository(private val api: LeaguesApi) {

    fun update(callback: (List<League>?) -> Unit) {
        api.getLeague().enqueue(object : Callback<Leagues> {
            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                callback.invoke(response.body()?.data)
            }

            override fun onFailure(call: Call<Leagues>, t: Throwable) {
                Log.e("MainViewModel", "Call Failed", t)
                callback.invoke(null)
            }
        })
    }
}




