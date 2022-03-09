package com.recu.tienda.data.database.dao


import androidx.room.*

import com.recu.tienda.data.database.entities.Entity
import com.recu.tienda.data.model.ProductObjectItem

@Dao
interface QuoteDao {
    @Query("SELECT * FROM Product ORDER BY Product.name")
    fun findProducts(): MutableList<ProductObjectItem>
    @Query("SELECT * FROM Product WHERE Product.id = :productId LIMIT 1")
    fun findProductById(productId: Int):Entity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(product: Entity)
    @Delete
    fun delete(product: Entity)
    @Query("DELETE FROM Product WHERE Product.name = :productName")
    fun deleteProd(productName: String)
    @Query("SELECT EXISTS (SELECT 1 FROM Product WHERE Product.name = :productName)")
    fun exists(productName: String): Boolean
    //@Query("SELECT COUNT(id) FROM Product")
    //fun checkIfEmpty()
}