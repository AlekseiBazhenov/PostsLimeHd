package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.db.entities.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post WHERE userId = :userId")
    suspend fun findByUserId(userId: Int): List<PostEntity>

    @Insert
    suspend fun insertAll(posts: List<PostEntity>)

    @Query("DELETE FROM post")
    suspend fun clear()
}