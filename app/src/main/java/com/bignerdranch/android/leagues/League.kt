package com.bignerdranch.android.leagues

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
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
    val slug: String
) : Parcelable
