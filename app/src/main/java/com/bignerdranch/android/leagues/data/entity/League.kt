package com.bignerdranch.android.leagues.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Leagues(
    val status: String,
    val data: List<League>
)

@Parcelize
data class League(
    val id: String,
    val abbr: String,
    val name: String,
    val slug: String,
    val logos: Logos
) : Parcelable

@Parcelize
data class Logos(val light: String, val dark: String) : Parcelable