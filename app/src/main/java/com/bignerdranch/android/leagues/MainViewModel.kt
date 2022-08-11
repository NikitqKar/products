package com.bignerdranch.android.leagues

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    val leagues = MutableLiveData(listOf<League>())

    fun update() {
        viewModelScope.launch {
            leagues.value = leagueRepository.getLeagues()
        }
    }
}


