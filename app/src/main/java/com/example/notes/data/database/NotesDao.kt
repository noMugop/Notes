//package com.example.notes.data.database
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.notes.data.database.module.UserInfoDbModel
//
//@Dao
//interface NotesDao {
//
//    @Query("SELECT * FROM users WHERE login == :login")
//    fun getUserByData(login: String): LiveData<UserInfoDbModel>
//
//    @Query("SELECT * FROM users")
//    fun getUserList(): LiveData<List<UserInfoDbModel>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun loadData(usersList: List<UserInfoDbModel>)
//}