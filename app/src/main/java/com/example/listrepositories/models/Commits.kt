package com.example.listrepositories.models


import com.google.gson.annotations.SerializedName

data class Commits(
    @SerializedName("href")
    val href: String
)