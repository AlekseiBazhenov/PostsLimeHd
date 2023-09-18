package com.example.users.presentation

import com.example.users.domain.UserUiModel

data class UiState(
    val users: List<UserUiModel> = emptyList()
)