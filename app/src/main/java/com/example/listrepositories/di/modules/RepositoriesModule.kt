package com.example.listrepositories.di.modules

import com.example.listrepositories.api.PullsRepoApi
import com.example.listrepositories.api.UserRepoApi
import com.example.listrepositories.repositories.PullsRepository
import com.example.listrepositories.repositories.PullsRepositoryImpl
import com.example.listrepositories.repositories.UserRepository
import com.example.listrepositories.repositories.UserRepositoryImpl
import org.koin.core.scope.get
import org.koin.dsl.module


val repositoriesModule = module {
    single <UserRepository> {
        provideUserRepository(get())
    }
    single <PullsRepository> {
        providePullRepository(get())
    }

}

fun provideUserRepository(userRepoApi: UserRepoApi): UserRepositoryImpl {
    return UserRepositoryImpl(userRepoApi)
}

fun providePullRepository(pullsRepoApi: PullsRepoApi): PullsRepositoryImpl {
    return PullsRepositoryImpl(pullsRepoApi)
}