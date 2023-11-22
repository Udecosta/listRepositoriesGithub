package com.example.listrepositories.models


import com.google.gson.annotations.SerializedName

data class Head(
    @SerializedName("label")
    val label: String,
    @SerializedName("ref")
    val ref: String,
    @SerializedName("repo")
    val repo: RepoX,
    @SerializedName("sha")
    val sha: String,
    @SerializedName("user")
    val user: UserXX
)