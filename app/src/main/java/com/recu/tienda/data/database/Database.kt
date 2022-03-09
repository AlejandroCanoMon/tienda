package com.recu.tienda.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.recu.tienda.data.database.dao.QuoteDao
import com.recu.tienda.data.database.entities.Entity


@Database(entities = [Entity::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}