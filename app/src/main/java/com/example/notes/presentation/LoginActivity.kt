package com.example.notes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.data.network.ApiFactory
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.domain.entity.UserInfo
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var token: Any
    private lateinit var profile: Any

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val user = UserInfo("testalina@mailsecv.com", "1q2w3e4r5t")
        val apiFactory = RemoteDataSourceImpl(ApiFactory())
        val apiService = apiFactory.getApiService()

        runBlocking {
            val request = launch {
                delay(500)
                token = apiService.authorization(user)
                profile = apiService.getProfile(token.toString())
            }
            request.join()
            println("Token: ${token}")
            println("Profile: ${profile}")
        }
    }
}

class RemoteDataSourceImpl (
    private val apiFactory: ApiFactory,
) {

    fun getApiService() = apiFactory.getInstance()
}
