package com.nick.android.products.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.android.products.data.ProductRepository
import com.nick.android.products.data.entity.Product
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


