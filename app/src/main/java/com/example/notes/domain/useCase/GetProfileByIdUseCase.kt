package com.example.notes.domain.useCase

import com.example.notes.domain.ProfileRepository
import javax.inject.Inject

class GetProfileByIdUseCase @Inject constructor(private val repository: ProfileRepository) {

    operator fun invoke(id: String) = repository.getProfileById(id)
}