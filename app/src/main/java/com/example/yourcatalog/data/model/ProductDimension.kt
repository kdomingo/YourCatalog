package com.example.yourcatalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductDimension(
    val width: Double = 0.0,
    val height: Double = 0.0,
    val depth: Double = 0.0
)
