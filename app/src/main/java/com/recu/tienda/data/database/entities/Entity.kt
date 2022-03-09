package com.recu.tienda.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Entity(
    @ColumnInfo(name = "available")
    val available: Boolean,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "discountPrice")
    val discountPrice: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val regularPrice: Double,
    @ColumnInfo(name = "stock")
    val stock: Int
)