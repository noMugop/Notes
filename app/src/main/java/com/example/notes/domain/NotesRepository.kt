package com.example.notes.domain

import androidx.lifecycle.LiveData
import com.example.notes.domain.entity.LoginRequest

interface NotesRepository {

    fun getUserList(): LiveData<List<LoginRequest>>

    fun getUserByData(login: String): LiveData<LoginRequest>

    fun loadData()
}