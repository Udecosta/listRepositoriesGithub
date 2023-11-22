package com.example.listrepositories.di.modules

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.listrepositories.repositories.PullsRepository
import com.example.listrepositories.repositories.UserRepository
import com.example.listrepositories.viewmodels.PullsRepositoryViewModel
import com.example.listrepositories.viewmodels.UserRepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        provideUserViewModel(get(), get())
    }
    viewModel {
        providePullViewModel(get(), get())
    }
}

fun provideUserViewModel(
    context: Context,
    userRepository: UserRepository
): UserRepositoryViewModel {
    return UserRepositoryViewModel(userRepository)
}

fun providePullViewModel(
    context: Context,
    pullsRepository: PullsRepository
): PullsRepositoryViewModel {
    return PullsRepositoryViewModel(pullsRepository)
}