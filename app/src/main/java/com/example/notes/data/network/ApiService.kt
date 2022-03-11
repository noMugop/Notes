package com.example.notes.data.network

import com.example.notes.data.network.module.TokenDto
import com.example.notes.domain.entity.LoginRequest
import retrofit2.http.*

interface ApiService {

    @POST("auth")
    suspend fun getToken(@Body userData: LoginRequest): TokenDto

    @GET("profile")
    suspend fun<T> getProfile(
        @Header("Authorization") auth: String
    ): T
}