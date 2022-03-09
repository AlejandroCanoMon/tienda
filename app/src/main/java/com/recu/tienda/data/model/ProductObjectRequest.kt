package com.recu.tienda.data.model

import com.google.gson.annotations.SerializedName

data class ProductObjectRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imageUrl")
    val imageURL: String,
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("regularPrice")
    val price: Float,
    @SerializedName("discountPrice")
    val discountPrice: Float,
    @SerializedName("stock")
    val stock: Int




)

