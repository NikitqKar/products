package com.nick.android.products.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nick.android.products.data.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}