package com.android.fundamentals.data.models

data class Move(
    val name: String,
    val avatar: String,
    val description: String,
    val reviews: String,
    val age: Int,
    val rating: Int,
    val hasLike: Boolean
)