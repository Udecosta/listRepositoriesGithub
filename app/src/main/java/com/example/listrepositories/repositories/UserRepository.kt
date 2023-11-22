package com.example.listrepositories.repositories

import com.example.listrepositories.models.Pulls
import com.example.listrepositories.models.Repositories
import retrofit2.Call

interface UserRepository {

    suspend fun getAllRepositories() : Repositories

}