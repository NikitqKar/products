package com.bignerdranch.android.leagues.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.leagues.data.entity.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<Product>)

    @Query("DELETE FROM product")
    fun clearProducts()
}