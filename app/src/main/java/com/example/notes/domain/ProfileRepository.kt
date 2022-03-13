package com.example.notes.domain

import androidx.lifecycle.LiveData
import com.example.notes.data.database.module.ProfileDbModel
import com.example.notes.domain.entity.Profile
import com.example.notes.presentation.models.Result

interface ProfileRepository {

    fun makeLoginRequest(email: String, password: String): Result<Profile>

    fun getProfileList(): LiveData<List<Profile>>

    fun getProfileById(id: String): LiveData<Profile>

    suspend fun loadData(profile: Profile)
}