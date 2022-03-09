package com.recu.tienda.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.recu.tienda.data.model.ProductObjectItem
import com.recu.tienda.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductAdapter(private val onProductClicked: (ProductObjectItem) -> Unit) :
    ListAdapter<ProductObjectItem, ProductAdapter.ViewHolder>(ProductItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ProductItemBinding = ProductItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Producto = getItem(position)

        val precioFinal = Producto.price
        holder.binding.tvItemName.text = Producto.name
        holder.binding.tvItemPrice.text = Producto.discountPrice.toString()
        holder.binding.tvItemStock.text = Producto.stock.toString()
        Picasso.get()
            .load(Producto.imageUrl)

            .into(holder.binding.imageView)

        if (Producto.stock < 5) {
        holder.binding.tvUnidad.text = "¡ULTIMAS UNIDADES!"
        } else { holder.binding.tvUnidad.text = ""}

        holder.binding.root.setOnClickListener {
            onProductClicked(Producto)
        }
    }

    inner class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)


}

class ProductItemCallback : DiffUtil.ItemCallback<ProductObjectItem>() {
    override fun areItemsTheSame(oldItem: ProductObjectItem, newItem: ProductObjectItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ProductObjectItem,
        newItem: ProductObjectItem
    ): Boolean = oldItem.id == newItem.id

}
