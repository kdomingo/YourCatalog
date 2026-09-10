package com.example.yourcatalog.data.datasource

import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.data.model.ProductsResponse
import com.example.yourcatalog.data.model.QueryOptions
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ProductApiImpl(
    private val client: HttpClient
) : ProductApi {

    override suspend fun getAll(queryOptions: QueryOptions): Result<ProductsResponse> {
        return runCatching<ProductApiImpl, ProductsResponse> {
            (client.takeIf { !queryOptions.query.isNullOrEmpty() }?.get("search") {
                queryOptions.query?.takeIf { it.isNotEmpty() }?.let { query ->
                    parameter("q", query)
                }
                parameter("limit", queryOptions.limit)
                parameter("skip", queryOptions.skip)
            } ?: client.get {}).body()
        }.fold(
            onSuccess = {
                Result.success(it)
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }

    override suspend fun getWithId(id: String): Result<Product> {
        return runCatching<ProductApiImpl, Product> {
            client.get(id).body()
        }.fold(
            onSuccess = {
                Result.success(it)
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }
}