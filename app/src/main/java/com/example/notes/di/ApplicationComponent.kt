package com.example.notes.di

import android.app.Application
import com.example.notes.di.annotations.ApplicationScope
import com.example.notes.di.modules.DataModule
import com.example.notes.di.modules.DomainModule
import com.example.notes.di.modules.ViewModelModule
import com.example.notes.presentation.*
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, DomainModule::class])
interface ApplicationComponent {

    fun inject(profileFragment: ProfileFragment)

    fun inject(profileFragment: LoginFragment)

    fun inject(application: MyApp)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}