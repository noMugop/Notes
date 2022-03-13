package com.example.notes.di.modules

import com.example.notes.data.repository.RepositoryImpl
import com.example.notes.domain.ProfileRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindProfileRepository(repository: RepositoryImpl): ProfileRepository
}