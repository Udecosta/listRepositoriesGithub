package com.example.listrepositories.models


import com.google.gson.annotations.SerializedName

data class Issue(
    @SerializedName("href")
    val href: String
)