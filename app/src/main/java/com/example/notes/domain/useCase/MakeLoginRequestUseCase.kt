package com.example.notes.domain.useCase

import com.example.notes.domain.ProfileRepository
import javax.inject.Inject

class MakeLoginRequestUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    operator fun invoke(email: String, password: String) = profileRepository.makeLoginRequest(email, password)
}