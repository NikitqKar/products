package com.bignerdranch.android.leagues.data.web

import android.util.Log
import com.bignerdranch.android.leagues.data.entity.League
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepository(private val api: LeaguesApi) {

    suspend fun getLeagues(): List<League> = withContext(Dispatchers.IO) {
        try {
            api.getLeague().data.shuffled()
        } catch (e: Exception) {
            Log.e("LeagueRepository","getLeagues error", e)
            emptyList()
        }
    }
}