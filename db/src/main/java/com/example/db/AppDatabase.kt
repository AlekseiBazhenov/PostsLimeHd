package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.entities.PostEntity
import com.example.db.entities.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao
}