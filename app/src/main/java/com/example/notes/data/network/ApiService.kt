package com.example.notes.data.network

import com.example.notes.data.network.module.ResultDto
import com.example.notes.data.network.module.UserInfoDto
import com.example.notes.domain.entity.UserInfo
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("auth")
    suspend fun authorization(@Body userData: UserInfo): ResultDto
}