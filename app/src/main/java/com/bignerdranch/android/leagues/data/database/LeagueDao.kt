package com.bignerdranch.android.leagues.data.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bignerdranch.android.leagues.data.entity.League

@Dao
interface LeaguesDao {

    @Query("SELECT * FROM leagues")
    fun getAllLeagues(): List<League>

    @Insert
    fun insertLeagues(leagues: League)
}