package com.example.notes.presentation.viewModel

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notes.domain.entity.Profile
import com.example.notes.domain.useCase.GetProfileByIdUseCase
import com.example.notes.domain.useCase.GetProfileListUseCase
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor(
    private val getProfileListUseCase: GetProfileListUseCase,
    private val getProfileByIdUseCase: GetProfileByIdUseCase
): ViewModel() {

    fun getProfileById(id: String) = getProfileByIdUseCase(id)

    fun getProfileList() = getProfileListUseCase()
}