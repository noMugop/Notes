package com.example.notes.domain.entity

data class Profile(

    val id: String = "",
    val name: String,
    val email: String,
    val phone: String,
    val avatar: String,
    val position: String,
    val companyName: String,
    val nameEng: String,
    val timezone: String,
    val alertEmail: String
)