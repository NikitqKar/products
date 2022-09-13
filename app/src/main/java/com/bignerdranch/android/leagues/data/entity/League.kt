package com.bignerdranch.android.leagues.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class Leagues(
    val status: String,
    val data: List<League>
)

@Parcelize
@Entity(tableName = "leagues")
data class League(
    val id: String,
    val abbr: String,
    val name: String,
    val slug: String,
    val logos: Logos,
    val index: Int? = null
) : Parcelable

@Parcelize
data class Logos(val light: String, val dark: String) : Parcelable