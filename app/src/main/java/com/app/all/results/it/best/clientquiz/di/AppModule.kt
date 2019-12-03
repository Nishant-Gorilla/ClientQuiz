package com.app.all.results.it.best.clientquiz.di

import com.app.all.results.it.best.clientquiz.ClientQuizApplication
import com.app.all.results.it.best.clientquiz.utils.CommonFunctions
import org.koin.core.module.Module
import org.koin.dsl.module


object AppModule {

    // declare all the modules here
    fun appModule(): Module = module {
        single { CommonFunctions() }

    }
}