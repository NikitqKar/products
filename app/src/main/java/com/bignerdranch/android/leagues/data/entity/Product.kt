package com.bignerdranch.android.leagues.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class Products(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

@Parcelize
@Entity(tableName = "product")
data class Product(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val index: Int? = null
) : Parcelable