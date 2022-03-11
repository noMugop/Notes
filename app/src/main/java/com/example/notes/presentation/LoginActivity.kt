package com.example.notes.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.example.notes.data.network.ApiFactory
import com.example.notes.data.network.ApiService
import com.example.notes.data.network.module.ResultDto
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.domain.entity.UserInfo
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var result: ResultDto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val user = UserInfo("testalina@mailsecv.com", "1q2w3e4r5t")
        val apiFactory = RemoteDataSourceImpl(ApiFactory())
        val apiService = apiFactory.getApiService()

        runBlocking {
            val request = launch {
                delay(500)
                result = apiService.authorization(user)
            }
            request.join()
            if (result != null) {
                println("Result + ${result.token}")
            } else {
                println("Error")
            }
        }
    }
}

class RemoteDataSourceImpl (
    private val apiFactory: ApiFactory,
) {

    fun getApiService() = apiFactory.getInstance()
}
