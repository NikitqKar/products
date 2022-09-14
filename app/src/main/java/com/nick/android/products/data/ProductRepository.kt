package com.nick.android.products.data

import android.util.Log
import com.nick.android.products.data.database.ProductDao
import com.nick.android.products.data.entity.Product
import com.nick.android.products.data.web.ProductApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val api: ProductApi, private val dao: ProductDao) {

    suspend fun getProducts(): List<Product> = withContext(Dispatchers.IO) {
        try {
            val products = api.getProducts().products.shuffled()
                .mapIndexed { index, it -> it.copy(index = index) }
            dao.clearProducts()
            dao.insertProducts(products)
            products
        } catch (e: Exception) {
            Log.e("ProductRepository", "getProduct error", e)
            dao.getProducts()
        }
    }
}