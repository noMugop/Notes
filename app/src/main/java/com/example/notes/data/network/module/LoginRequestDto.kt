package com.example.notes.data.network.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequestDto(

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("password")
    @Expose
    val password: String
    )
