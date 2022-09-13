package com.bignerdranch.android.leagues.data.web

import com.bignerdranch.android.leagues.data.entity.Products
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): Products
}