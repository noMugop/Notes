package com.example.notes.domain.useCase

import com.example.notes.domain.ProfileRepository
import javax.inject.Inject

class GetProfileListUseCase @Inject constructor(private val repository: ProfileRepository) {

    operator fun invoke() = repository.getProfileList()
}