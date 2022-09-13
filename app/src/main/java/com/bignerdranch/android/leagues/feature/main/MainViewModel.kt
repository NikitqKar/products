package com.bignerdranch.android.leagues.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.leagues.data.ProductRepository
import com.bignerdranch.android.leagues.data.entity.Product
import com.bignerdranch.android.leagues.data.entity.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData(listOf<Product>())
    val products: MutableLiveData<List<Product>> = _products

    fun update() {
        viewModelScope.launch {
            _products.value = productRepository.getProducts()
        }
    }
}


