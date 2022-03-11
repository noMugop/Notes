package com.example.notes.data.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
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

            val logging = OAuthInterceptor("Bearer", "---ACCESS---TOKEN---")

            val client = OkHttpClient
                .Builder()
                .addInterceptor(logging)
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val instance = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(client)
                .build()

            retrofit = instance
            apiService = instance.create(ApiService::class.java)
            return apiService as ApiService
        }
    }

    companion object {

        private var retrofit: Retrofit? = null

        private var apiService: ApiService? = null

        private const val BASE_URL = "https://dev-api.ringapp.me/"

        private val LOCK = Any()
    }

    class OAuthInterceptor(
        private val tokenType: String, private val accessToken: String
        ): Interceptor {

        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request = chain.request()
            request = request.newBuilder()
                .header("Authorization", "$tokenType $accessToken")
                .build()

            return chain.proceed(request)
        }
    }
}