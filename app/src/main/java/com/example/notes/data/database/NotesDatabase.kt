//package com.example.notes.data.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.notes.data.database.module.UserInfoDbModel
//import com.example.notes.domain.entity.UserInfo
//
//@Database(entities = [UserInfoDbModel::class], version = 1, exportSchema = false)
//abstract class NotesDatabase: RoomDatabase() {
//
//    companion object {
//
//        private var db: NotesDatabase? = null
//        private const val DB_NAME = "main.db"
//        private val LOCK = Any()
//
//        fun getInstance(context: Context): NotesDatabase {
//            synchronized(LOCK) {
//                db?.let { return it }
//                val instance =
//                    Room.databaseBuilder(
//                        context,
//                        NotesDatabase::class.java,
//                        DB_NAME
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                db = instance
//                return instance
//            }
//        }
//    }
//
//    abstract fun userInfoDao(): UserInfoDbModel
//}