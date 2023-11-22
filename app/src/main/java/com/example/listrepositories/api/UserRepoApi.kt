package com.example.listrepositories.api

import com.example.listrepositories.models.Pulls
import com.example.listrepositories.models.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface UserRepoApi {

    @Headers("Accept: application/json")
    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    suspend fun getAllRepositories() : Repositories


}