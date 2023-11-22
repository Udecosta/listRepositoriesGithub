package com.example.listrepositories.repositories

import com.example.listrepositories.models.Pulls

interface PullsRepository {
    suspend fun getAllPulls(owner: String, repo: String) : Pulls
}