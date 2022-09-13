package com.bignerdranch.android.leagues.data.web

import android.util.Log
import com.bignerdranch.android.leagues.data.database.LeagueDao
import com.bignerdranch.android.leagues.data.entity.League
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepository(private val api: LeaguesApi, private val dao: LeagueDao) {

    suspend fun getLeagues(): List<League> = withContext(Dispatchers.IO) {
        try {
            val leagues = api.getLeague().data.shuffled()
                .mapIndexed { index, it -> it.copy(index = index) }
            dao.clearLeagues()
            dao.insertLeagues(leagues)
            leagues
        } catch (e: Exception) {
            Log.e("LeagueRepository", "getLeagues error", e)
            dao.getLeagues()
        }
    }
}