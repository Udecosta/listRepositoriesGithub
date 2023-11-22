package com.example.listrepositories.repositories

import com.example.listrepositories.api.PullsRepoApi
import com.example.listrepositories.api.UserRepoApi
import com.example.listrepositories.models.Pulls

class PullsRepositoryImpl(private val pullsRepoApi: PullsRepoApi) : PullsRepository {
   override suspend fun getAllPulls(owner: String, repo: String) = pullsRepoApi.getAllPulls(owner = owner, repo = repo)
}
