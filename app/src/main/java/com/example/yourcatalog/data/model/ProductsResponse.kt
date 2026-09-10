package com.example.yourcatalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    val products: List<Product> = emptyList()
)
