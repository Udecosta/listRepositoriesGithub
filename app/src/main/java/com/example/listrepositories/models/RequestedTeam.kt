package com.example.listrepositories.models


import com.google.gson.annotations.SerializedName

data class RequestedTeam(
    @SerializedName("description")
    val description: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("members_url")
    val membersUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("notification_setting")
    val notificationSetting: String,
    @SerializedName("parent")
    val parent: Any,
    @SerializedName("permission")
    val permission: String,
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("repositories_url")
    val repositoriesUrl: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("url")
    val url: String
)