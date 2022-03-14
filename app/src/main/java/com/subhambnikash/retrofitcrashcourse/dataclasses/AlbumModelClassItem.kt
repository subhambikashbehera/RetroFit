package com.subhambnikash.retrofitcrashcourse.dataclasses

import com.google.gson.annotations.SerializedName

data class AlbumModelClassItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)