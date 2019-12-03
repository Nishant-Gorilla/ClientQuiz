package com.app.all.results.it.best.clientquiz

import android.app.Application
import com.app.all.results.it.best.clientquiz.di.AppModule
import org.koin.core.context.startKoin

class ClientQuizApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // declare modules
            modules(AppModule.appModule())
        }
    }
}