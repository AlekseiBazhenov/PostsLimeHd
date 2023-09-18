package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.db.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>

    @Insert
    suspend fun insertAll(users: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun clear()
}