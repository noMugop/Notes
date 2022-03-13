package com.example.notes.domain.useCase

import com.example.notes.data.database.module.ProfileDbModel
import com.example.notes.domain.ProfileRepository
import com.example.notes.domain.entity.Profile
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: ProfileRepository) {

    suspend operator fun invoke(profile: Profile) = repository.loadData(profile)
}