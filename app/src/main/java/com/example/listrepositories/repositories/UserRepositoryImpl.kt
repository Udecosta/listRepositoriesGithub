package com.example.listrepositories.repositories

import com.example.listrepositories.api.UserRepoApi
import com.example.listrepositories.models.Pulls
import com.example.listrepositories.models.Repositories
import retrofit2.Call

class UserRepositoryImpl(private val userRepoApi: UserRepoApi) : UserRepository {

    override suspend fun getAllRepositories(): Repositories = userRepoApi.getAllRepositories()
}