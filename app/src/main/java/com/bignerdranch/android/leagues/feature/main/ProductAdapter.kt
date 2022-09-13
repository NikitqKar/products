package com.bignerdranch.android.leagues.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.leagues.databinding.ListItemProductBinding
import coil.load
import com.bignerdranch.android.leagues.data.entity.Product

class ProductAdapter(private val onItemClick: ((Product) -> Unit)) :
    ListAdapter<Product, ProductAdapter.ProductHolder>(ProductsDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductHolder(
        ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(getItem(position))
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
                productIndexTv.text = "${product.index}"
                imageView.load(product.thumbnail)
            }
        }
    }
}

class ProductsDiff : DiffUtil.ItemCallback<Product>() {

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

    override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id
}
