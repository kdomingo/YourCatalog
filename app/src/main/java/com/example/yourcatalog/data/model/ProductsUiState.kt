package com.example.yourcatalog.data.model

data class ProductsUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val products: List<Product> = emptyList()
)
