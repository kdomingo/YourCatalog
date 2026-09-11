package com.example.yourcatalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class QueryOptions(
    val query: String? = null,
    val limit: Int = 20,
    val skip: Int = 0
)
