package com.example.notes.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notes.data.database.module.ProfileDbModel
import com.example.notes.data.network.module.ProfileDto

@Dao
interface ProfileDao {

    @Query("SELECT * FROM users WHERE id == :id")
    fun getProfileById(id: String): LiveData<ProfileDbModel>

    @Query("SELECT * FROM users")
    fun getProfileList(): LiveData<List<ProfileDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun loadData(profileList: List<ProfileDbModel>)
}