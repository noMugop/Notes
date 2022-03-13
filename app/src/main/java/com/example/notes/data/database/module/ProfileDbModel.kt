package com.example.notes.data.database.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class ProfileDbModel (

    @PrimaryKey(autoGenerate = false)
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