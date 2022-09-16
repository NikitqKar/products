package com.nick.android.products.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nick.android.products.data.entity.Product
import com.nick.android.products.databinding.ListItemProductBinding

class ProductAdapter(private val onItemClick: ((Product) -> Unit)) :
    PagingDataAdapter<Product, ProductAdapter.ProductHolder>(ProductsDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductHolder(
        ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ProductHolder(private val binding: ListItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                root.setOnClickListener { onItemClick(product) }
                productBrand.text = product.brand
                productPrice.text = product.price.toString()
                productDescription.text = product.description
                productTitle.text = product.title
                productIndexTv.text = "${product.id}"
                imageView.load(product.thumbnail)
            }
        }
    }
}

class ProductsDiff : DiffUtil.ItemCallback<Product>() {

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

    override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id
}