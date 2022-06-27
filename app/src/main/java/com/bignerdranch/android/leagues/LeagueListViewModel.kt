package com.bignerdranch.android.leagues

import androidx.lifecycle.ViewModel

class LeagueListViewModel : ViewModel() {

    val Leagues = mutableListOf<League>()

    init {
        for (i in 0 until 100) {
            val league = League()
            league.title = "League #$i"
            Leagues += league
        }
    }
}