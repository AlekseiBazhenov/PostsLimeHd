package com.example.users.data

import com.example.db.entities.UserEntity

interface UsersRepository {
    suspend fun getUsers(): List<UserEntity>
}