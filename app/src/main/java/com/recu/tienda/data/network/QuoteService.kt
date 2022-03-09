/*package com.recu.tienda.data.network

import com.recu.tienda.data.model.ProductObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import retrofit2.*


class QuoteService @Inject constructor(private val api:ProductEndpoints) {

    suspend fun getQuotes(): List<ProductObject> {
        return withContext(Dispatchers.IO) {
            val response = api.getProducts()
            response.body() ?: emptyList()
        }
    }

}*/