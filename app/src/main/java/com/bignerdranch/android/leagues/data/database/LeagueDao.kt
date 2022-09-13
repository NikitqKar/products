package com.bignerdranch.android.leagues.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.leagues.data.entity.League

@Dao
interface LeagueDao {

    @Query("SELECT * FROM leagues")
    fun getLeagues(): List<League>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeague(leagues: League)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeagues(leagues: List<League>)

    @Query("DELETE FROM leagues")
    fun clearLeagues()
}