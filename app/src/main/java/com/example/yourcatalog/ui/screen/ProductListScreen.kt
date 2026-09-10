package com.example.yourcatalog.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeRuntimeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.yourcatalog.data.model.Product
import com.example.yourcatalog.ui.viewmodel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeRuntimeApi::class)
@Composable
fun ProductListScreen(modifier: Modifier = Modifier, viewModel: ProductsViewModel = koinViewModel()) {

    val searchState = rememberTextFieldState()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(searchState) {

        snapshotFlow { searchState.text }
            .collect { query ->
                viewModel.search(query.toString())
            }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(state = searchState)
            ProductList(products = state.products) { product ->
            }
        }
    }
}

@Composable
private fun ProductList(products: List<Product> = emptyList(), onProductTapped: (Product) -> Unit = {}) {
    LazyColumn {
        items(items = products, key = {
            it.id
        }) { product ->
            ProductRow(product = product)
        }
    }
}

@Composable
private fun ProductRow(product: Product, onProductTapped: (Product) -> Unit = {}) {
    val thumbnailIcon = rememberVectorPainter(Icons.Filled.ShoppingCart)
    Row(
        modifier = Modifier.clickable {
            onProductTapped(product)
        }
    ) {
        AsyncImage(
            model = product.thumbnail,
            fallback = thumbnailIcon,
            modifier = Modifier.size(80.dp),
            contentDescription = "Product thumbnail"
        )
        Column {
            Text(product.title)
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(Icons.Filled.Star, contentDescription = "Rating star")
                Text("%.1f".format(product.rating))
            }
        }
    }
}