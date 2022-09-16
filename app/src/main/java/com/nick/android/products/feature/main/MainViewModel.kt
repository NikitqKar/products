package com.nick.android.products.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.nick.android.products.data.ProductPagingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: ProductPagingDataSource
) : ViewModel() {

    val products = Pager(
        PagingConfig(pageSize = 10, initialLoadSize = 10, prefetchDistance = 2),
        pagingSourceFactory = { dataSource }
    ).flow.cachedIn(viewModelScope)
}