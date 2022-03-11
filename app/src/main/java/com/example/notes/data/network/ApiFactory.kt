package com.example.notes.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiFactory {

    fun getInstance(): ApiService {

        apiService?.let { return it }

        synchronized(LOCK) {
            apiService?.let { return it }

            val instance = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()

            retrofit = instance
            apiService = instance.create(ApiService::class.java)
            return apiService as ApiService
        }
    }

    companion object {

        private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        private val client = OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .build()

        private var retrofit: Retrofit? = null

        private var apiService: ApiService? = null

        private const val BASE_URL = "https://dev-api.ringapp.me/"

        private val LOCK = Any()
    }
}