package com.example.yourcatalog.data.datasource

import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.data.model.ProductsResponse
import com.example.yourcatalog.data.model.QueryOptions

interface ProductApi {
    suspend fun getAll(queryOptions: QueryOptions): ProductsResponse
    suspend fun getWithId(id: String): Product?
}