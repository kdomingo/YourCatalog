package com.example.yourcatalog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourcatalog.data.model.ProductsUiState
import com.example.yourcatalog.data.model.QueryOptions
import com.example.yourcatalog.data.service.ProductService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val service: ProductService
): ViewModel() {

    private val _state = MutableStateFlow(ProductsUiState())
    val state = _state.asStateFlow()

    fun search(query: String) {

        viewModelScope.launch {
            val result = service.getAll(QueryOptions(query = query))
            result.fold(
                onSuccess = {
                    _state.update { currentState -> currentState.copy(loading = false, products = it) }
                },
                onFailure = {
                    _state.update { currentState -> currentState.copy(loading = false, error = true) }
                }
            )
        }
    }
}