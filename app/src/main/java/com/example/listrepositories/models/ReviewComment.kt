package com.example.listrepositories.models


import com.google.gson.annotations.SerializedName

data class ReviewComment(
    @SerializedName("href")
    val href: String
)