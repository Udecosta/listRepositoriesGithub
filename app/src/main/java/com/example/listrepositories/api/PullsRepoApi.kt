package com.example.listrepositories.api

import com.example.listrepositories.models.Pulls
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PullsRepoApi {
    @Headers("Accept: application/json")
    @GET("/repos/{owner}/{repo}/pulls")
    suspend fun getAllPulls(@Path("owner") owner: String, @Path("repo") repo: String) : Pulls
}