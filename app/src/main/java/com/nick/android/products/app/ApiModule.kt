package com.nick.android.products.app

import android.content.Context
import androidx.room.Room
import com.nick.android.products.data.ProductRepository
import com.nick.android.products.data.database.ProductDao
import com.nick.android.products.data.database.ProductDatabase
import com.nick.android.products.data.web.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ProductApi = retrofit.create(ProductApi::class.java)

    @Provides
    @Singleton
    fun provideRepo(api: ProductApi, dao: ProductDao): ProductRepository = ProductRepository(api, dao)

    @Provides
    @Singleton
    fun provideProductDao(productDatabase: ProductDatabase): ProductDao = productDatabase.productDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ProductDatabase = Room.databaseBuilder(
        appContext, ProductDatabase::class.java, "ProductDatabase"
    ).build()
}