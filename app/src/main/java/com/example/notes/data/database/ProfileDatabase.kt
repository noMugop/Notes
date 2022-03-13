package com.example.notes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.data.database.module.ProfileDbModel

@Database(entities = [ProfileDbModel::class], version = 1, exportSchema = false)
abstract class ProfileDatabase: RoomDatabase() {

    companion object {

        private var db: ProfileDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): ProfileDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        ProfileDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun userInfoDao(): ProfileDao
}