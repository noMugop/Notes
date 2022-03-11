package com.example.notes.domain.entity

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
    )
