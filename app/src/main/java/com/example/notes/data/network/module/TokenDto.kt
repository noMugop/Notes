package com.example.notes.data.network.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenDto(

    @SerializedName("token")
    @Expose
    val token: String,
    @SerializedName("sections")
    @Expose
    val sections: List<String>
)