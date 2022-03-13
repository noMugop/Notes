package com.example.notes.di.modules

import android.app.Application
import com.example.notes.data.database.ProfileDao
import com.example.notes.data.database.ProfileDatabase
import com.example.notes.data.network.ApiFactory
import com.example.notes.data.network.ApiService
import com.example.notes.di.annotations.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    companion object {

        @Provides
        @ApplicationScope
        fun provideProfileDao(application: Application): ProfileDao {
            return ProfileDatabase.getInstance(application).userInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }

}