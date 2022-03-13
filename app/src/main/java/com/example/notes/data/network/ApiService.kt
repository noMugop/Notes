package com.example.notes.data.network

import com.example.notes.data.network.module.ProfileDto
import com.example.notes.data.network.module.TokenDto
import com.example.notes.data.network.module.LoginRequestDto
import retrofit2.http.*

interface ApiService {

    @POST("auth")
    suspend fun getToken(@Body userData: LoginRequestDto): TokenDto

    @GET("profile")
    suspend fun getProfile(
        @Header("Authorization") token: String
    ): ProfileDto
}