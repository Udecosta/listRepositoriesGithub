package com.example.listrepositories.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class PullsItem(
    @SerializedName("active_lock_reason")
    val activeLockReason: String,
    @SerializedName("assignee")
    val assignee: @RawValue Assignee,
    @SerializedName("assignees")
    val assignees: @RawValue List<Assignee>,
    @SerializedName("author_association")
    val authorAssociation: String,
    @SerializedName("auto_merge")
    val autoMerge:@RawValue Any,
    @SerializedName("base")
    val base:@RawValue Base,
    @SerializedName("body")
    val body: String,
    @SerializedName("closed_at")
    val closedAt: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    @SerializedName("commits_url")
    val commitsUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("diff_url")
    val diffUrl: String,
    @SerializedName("draft")
    val draft: Boolean,
    @SerializedName("head")
    val head:@RawValue Head,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("issue_url")
    val issueUrl: String,
    @SerializedName("_links")
    val links:@RawValue Links,
    @SerializedName("locked")
    val locked: Boolean,
    @SerializedName("merge_commit_sha")
    val mergeCommitSha: String,
    @SerializedName("merged_at")
    val mergedAt: String,
    @SerializedName("milestone")
    val milestone:@RawValue Milestone,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("patch_url")
    val patchUrl: String,
    @SerializedName("requested_reviewers")
    val requestedReviewers:@RawValue List<RequestedReviewer>,
    @SerializedName("requested_teams")
    val requestedTeams:@RawValue List<RequestedTeam>,
    @SerializedName("review_comment_url")
    val reviewCommentUrl: String,
    @SerializedName("review_comments_url")
    val reviewCommentsUrl: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("statuses_url")
    val statusesUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user:@RawValue UserXXX
): Parcelable