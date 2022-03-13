package com.example.notes.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(

    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val avatar: String,
    val position: String,
    val companyName: String,
    val nameEng: String,
    val timezone: String,
    val alertEmail: String
): Parcelable