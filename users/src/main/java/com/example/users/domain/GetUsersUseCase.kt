package com.example.users.domain

import com.example.users.data.UsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend operator fun invoke(): List<UserUiModel> {
        return usersRepository.getUsers().map { entity ->
            UserUiModel(
                entity.id,
                entity.name,
                entity.username,
                entity.email,
                entity.phone,
                entity.website
            )
        }
    }
}