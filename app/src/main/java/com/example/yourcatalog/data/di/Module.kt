package com.example.yourcatalog.data.di

import com.example.yourcatalog.data.client.httpClient
import com.example.yourcatalog.data.datasource.ProductApi
import com.example.yourcatalog.data.datasource.ProductApiImpl
import com.example.yourcatalog.data.repository.ProductRepository
import com.example.yourcatalog.data.repository.ProductRepositoryImpl
import com.example.yourcatalog.data.service.ProductService
import com.example.yourcatalog.data.service.ProductServiceImpl
import com.example.yourcatalog.ui.viewmodel.ProductsViewModel
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object Module {

    fun appModule () = module {
        single<HttpClient> { httpClient }
        single<ProductApi> { ProductApiImpl(get()) }
        single<ProductRepository> { ProductRepositoryImpl(get()) }
        single<ProductService> { ProductServiceImpl(get()) }
        viewModel { ProductsViewModel(get()) }
    }
}