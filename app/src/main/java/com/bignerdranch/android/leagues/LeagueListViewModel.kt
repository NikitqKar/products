package com.bignerdranch.android.leagues

import androidx.lifecycle.ViewModel

class LeagueListViewModel : ViewModel() {

    val leagues = List(100) {League("League #$it")}
}