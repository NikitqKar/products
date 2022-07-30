package com.bignerdranch.android.leagues

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    val leagues = MutableLiveData(listOf<League>())

    fun update() {
        leagueRepository.update { leagues.value = it ?: emptyList() }
    }
}