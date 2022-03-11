package com.example.notes.domain.useCase

import com.example.notes.domain.NotesRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: NotesRepository) {

    operator fun invoke() = repository.loadData()
}