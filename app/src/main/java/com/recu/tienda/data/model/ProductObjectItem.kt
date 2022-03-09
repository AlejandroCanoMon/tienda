package com.recu.tienda.data.model

import com.google.gson.annotations.SerializedName

data class ProductObjectItem(
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("discountPrice")
    val discountPrice: Float,
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("imageUrl")
    val imageUrl: String
)
