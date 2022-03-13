package com.example.notes.data.network.module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileDto(

    @SerializedName("id")
    @Expose
    val id: String = "",
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("phone")
    @Expose
    val phone: String,
    @SerializedName("avatar")
    @Expose
    val avatar: String,
    @SerializedName("position")
    @Expose
    val position: String,
    @SerializedName("company_name")
    @Expose
    val companyName: String,
    @SerializedName("name_eng")
    @Expose
    val nameEng: String,
    @SerializedName("timezone")
    @Expose
    val timezone: String,
    @SerializedName("alert_email")
    @Expose
    val alertEmail: String
)