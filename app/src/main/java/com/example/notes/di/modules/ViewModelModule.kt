package com.example.notes.di.modules

import androidx.lifecycle.ViewModel
import com.example.notes.di.annotations.ViewModelKey
import com.example.notes.presentation.viewModel.LoginFragmentViewModel
import com.example.notes.presentation.viewModel.ProfileFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    fun bindLoginViewModel(fragmentViewModel: LoginFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    fun bindProfileFragmentViewModel(viewModel: ProfileFragmentViewModel): ViewModel
}