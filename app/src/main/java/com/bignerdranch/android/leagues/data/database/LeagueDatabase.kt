package com.bignerdranch.android.leagues.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bignerdranch.android.leagues.data.entity.League

@Database(entities = [League::class], version = 1)
abstract class LeagueDatabase : RoomDatabase() {
    abstract fun leagueDao(): LeagueDao
}