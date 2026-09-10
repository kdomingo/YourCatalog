package com.example.yourcatalog.data.di

import com.example.yourcatalog.data.client.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

object Module {

    fun appModule () = module {
        single<HttpClient> { httpClient }
    }
}