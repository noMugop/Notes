package com.example.notes.domain

import androidx.lifecycle.LiveData
import com.example.notes.domain.entity.UserInfo

interface NotesRepository {

    fun getUserList(): LiveData<List<UserInfo>>

    fun getUserByData(login: String): LiveData<UserInfo>

    fun loadData()
}