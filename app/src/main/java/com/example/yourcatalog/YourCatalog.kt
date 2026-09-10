package com.example.yourcatalog

import android.app.Application
import com.example.yourcatalog.data.di.Module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class YourCatalog: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@YourCatalog)
            modules(Module.appModule())
        }
    }
}