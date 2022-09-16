package com.nick.android.products.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nick.android.products.data.entity.Product
import com.nick.android.products.data.web.ProductApi

class ProductPagingDataSource(private val api: ProductApi) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> = try {
        val pageNumber = params.key ?: 0
        val response = api.getProducts(limit = params.loadSize, skip = pageNumber * params.loadSize)
        val prevKey = if (pageNumber > 0) pageNumber - 1 else null
        val nextKey = if (response.products.isNotEmpty()) pageNumber + 1 else null
        LoadResult.Page(
            data = response.products,
            prevKey = prevKey,
            nextKey = nextKey
        )
    } catch (e: Exception) {
        LoadResult.Error(e)
    }

    override fun getRefreshKey(state: PagingState<Int, Product>) =
        state.anchorPosition?.let { pos ->
            state.closestPageToPosition(pos)?.let { page ->
                page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
            }
        }
}