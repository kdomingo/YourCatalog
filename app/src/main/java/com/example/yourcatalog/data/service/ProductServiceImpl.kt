package com.example.yourcatalog.data.service

import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.data.model.QueryOptions
import com.example.yourcatalog.data.repository.ProductRepository

class ProductServiceImpl(private val repository: ProductRepository) : ProductService {
    override suspend fun getAll(queryOptions: QueryOptions): Result<List<Product>> {
        return repository.getAll(queryOptions)
            .fold(
                onSuccess = {
                    Result.success(it.products)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
    }

    override suspend fun getWithId(id: String): Result<Product> {
        return repository.getWithId(id)
            .fold(
                onSuccess = {
                    Result.success(it)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
    }
}