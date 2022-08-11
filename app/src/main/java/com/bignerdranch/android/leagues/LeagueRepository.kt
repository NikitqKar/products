package com.bignerdranch.android.leagues

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*

class LeagueRepository(private val api: LeaguesApi) {

  suspend fun update(function: () -> Any): Call<Leagues> = withContext(Dispatchers.IO) {
    api.getLeague()
  }
}




