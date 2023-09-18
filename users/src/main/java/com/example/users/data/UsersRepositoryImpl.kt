package com.example.users.data

import com.example.db.UserDao
import com.example.db.entities.UserEntity
import com.example.network.BackendApi
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: BackendApi,
    private val userDao: UserDao
) : UsersRepository {
    override suspend fun getUsers(): List<UserEntity> {
        return try {
            val response = api.getUsers()
            val entities = response.map { user ->
                UserEntity(user.id, user.name, user.username, user.email, user.phone, user.website)
            }
            userDao.clear()
            userDao.insertAll(entities)
            entities
        } catch (e: Exception) {
            userDao.getAll()
        }
    }
}