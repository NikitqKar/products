package com.nick.android.products.data.web

import com.nick.android.products.data.entity.Products
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): Products
}