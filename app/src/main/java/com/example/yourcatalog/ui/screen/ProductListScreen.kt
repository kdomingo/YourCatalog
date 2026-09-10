package com.example.yourcatalog.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeRuntimeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.yourcatalog.ui.viewmodel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeRuntimeApi::class)
@Composable
fun ProductListScreen(modifier: Modifier = Modifier, viewModel: ProductsViewModel = koinViewModel()) {

    val searchState = rememberTextFieldState()
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(searchState) {

        snapshotFlow { searchState.text }
            .collect { query ->
                viewModel.search(query.toString())
            }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(state = searchState)
            ProductList()
        }
    }
}

@Composable
private fun ProductList(modifier: Modifier = Modifier) {

}