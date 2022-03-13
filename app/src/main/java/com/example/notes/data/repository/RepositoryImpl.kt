package com.example.notes.data.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.notes.R
import com.example.notes.data.database.ProfileDao
import com.example.notes.data.database.module.ProfileDbModel
import com.example.notes.data.mapper.ProfileMapper
import com.example.notes.data.network.ApiService
import com.example.notes.data.network.module.LoginRequestDto
import com.example.notes.data.network.module.DataSource
import com.example.notes.data.network.module.ProfileDto
import com.example.notes.data.network.module.TokenDto
import com.example.notes.domain.ProfileRepository
import com.example.notes.domain.entity.Profile
import javax.inject.Inject
import com.example.notes.presentation.models.Result
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import java.lang.RuntimeException

class RepositoryImpl @Inject constructor(
    private val mapper: ProfileMapper,
    private val apiService: ApiService,
    private val profileDao: ProfileDao,
    private val dataSource: DataSource,
    private val application: Application
) : ProfileRepository {

    override fun getProfileList(): LiveData<List<Profile>> {
        return Transformations.map(profileDao.getProfileList()) {
            it.map { mapper.mapDbModelToProfile(it) }
        }
    }

    override fun getProfileById(id: String): LiveData<Profile> {
        return Transformations.map(profileDao.getProfileById(id)) {
             mapper.mapDbModelToProfile(it)
        }
    }

    override suspend fun loadData(profile: Profile) {
        val profileList = listOf<ProfileDbModel>()
        profileList.map { mapper.mapProfileToDbModel(profile) }
        profileDao.loadData(profileList)
    }

    override fun makeLoginRequest(email: String, password: String): Result<Profile> {

        val user = LoginRequestDto(email, password)
        var profileDto: ProfileDto? = null
        var result: Result<Profile>? = null
        var token: TokenDto? = null

        runBlocking {
            val job = launch {
                delay(1000)
                try {
                    token = apiService.getToken(user)
                } catch (e: Exception) {
                }
                if (token != null) {
                    profileDto = apiService.getProfile("Bearer" + token?.token)
                }
            }
            job.join()
            delay(1000)
            if (profileDto != null) {
                result = dataSource.login(profileDto as ProfileDto)
            }
            if (result is Result.Success && result != null) {
                val profile = mapper.mapDtoToProfile(profileDto as ProfileDto)
                loadData(profile)
            }
        }
        return result as Result<Profile>
    }
}