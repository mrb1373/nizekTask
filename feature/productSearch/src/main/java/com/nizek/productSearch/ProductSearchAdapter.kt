package com.nizek.productSearch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nizek.network.data.Product
import com.squareup.picasso.Picasso

class ProductSearchAdapter :
    ListAdapter<Product, ProductSearchAdapter.ViewHolder>(ProductDiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productImage: ImageView = itemView.findViewById(R.id.productImage)
        fun bind(product: Product) {
            productName.text = product.title
            Picasso.get()
                .load(product.thumbnail)
                .centerCrop()
                .resize(64, 64)
                .into(productImage)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id // Compare IDs
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem // Compare entire object
        }
    }
}