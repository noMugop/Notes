package com.example.notes.data.network.module

import com.google.gson.annotations.SerializedName

class TokenDto(

    @SerializedName("token")
    val token: String,
    @SerializedName("sections")
    val sections: List<String>
)