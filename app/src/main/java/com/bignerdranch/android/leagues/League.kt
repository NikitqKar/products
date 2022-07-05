package com.bignerdranch.android.leagues

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    var title: String = ""
) : Parcelable
