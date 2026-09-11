package com.example.yourcatalog.data.service

import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.data.model.QueryOptions

interface ProductService {
    suspend fun getAll(queryOptions: QueryOptions): Result<List<Product>>
    suspend fun getWithId(id: String): Result<Product>
}