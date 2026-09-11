package com.example.yourcatalog.data.repository

import com.example.yourcatalog.data.datasource.ProductApi
import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.data.model.ProductsResponse
import com.example.yourcatalog.data.model.QueryOptions

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {
    override suspend fun getAll(queryOptions: QueryOptions): Result<ProductsResponse> {
        return api.getAll(queryOptions)
    }

    override suspend fun getWithId(id: String): Result<Product> {
        return api.getWithId(id)
    }
}