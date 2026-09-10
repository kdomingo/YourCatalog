package com.example.yourcatalog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourcatalog.data.model.ProductsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {

    private val _state = MutableStateFlow<ProductsUiState>(ProductsUiState())
    val state = _state.asStateFlow()

    fun search(query: String) {
        
        viewModelScope.launch {

        }
    }
}