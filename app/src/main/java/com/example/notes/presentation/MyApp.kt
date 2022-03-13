package com.example.notes.presentation

import android.app.Application
import com.example.notes.di.DaggerApplicationComponent

class MyApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}