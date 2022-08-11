package com.bignerdranch.android.leagues

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepository(private val api: LeaguesApi) {

    suspend fun getLeagues(): List<League> = withContext(Dispatchers.IO) {
        try {
            api.getLeague().data
        } catch (e: Exception) {
            Log.e("LeagueRepository","getLeagues error", e)
            emptyList()
        }
    }
}