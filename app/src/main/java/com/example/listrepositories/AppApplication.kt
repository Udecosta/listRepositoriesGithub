package com.example.listrepositories

import android.app.Application
import com.example.listrepositories.di.modules.apiModule
import com.example.listrepositories.di.modules.appModules
import com.example.listrepositories.di.modules.repositoriesModule
import com.example.listrepositories.viewmodels.PullsRepositoryViewModel
import com.example.listrepositories.viewmodels.UserRepositoryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(appModules)
        }
    }

}