package com.example.notes.data.network.module

import com.example.notes.data.mapper.ProfileMapper
import com.example.notes.domain.entity.Profile
import com.example.notes.presentation.models.Result
import java.io.IOException
import javax.inject.Inject

class DataSource @Inject constructor(
    private val mapper: ProfileMapper
) {

    fun login(profileDto: ProfileDto): Result<Profile> {
        try {
            val profile = mapper.mapDtoToProfile(profileDto)
            return Result.Success(profile)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
}