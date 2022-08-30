package com.bignerdranch.android.leagues.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.leagues.data.entity.League
import com.bignerdranch.android.leagues.data.web.LeagueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    private val _leagues = MutableLiveData(listOf<League>())
    val leagues: LiveData<List<League>> = _leagues

    fun update() {
        viewModelScope.launch {
            _leagues.value = leagueRepository.getLeagues()
        }
    }
}


