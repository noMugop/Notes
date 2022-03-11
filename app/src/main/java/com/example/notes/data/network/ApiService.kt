package com.example.notes.data.network

import com.example.notes.domain.entity.UserInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("auth")
    suspend fun<T> authorization(@Body userData: UserInfo): T

    @GET("profile")
    suspend fun<T> getProfile(
        @Query("token") token: Any
    ): T
}