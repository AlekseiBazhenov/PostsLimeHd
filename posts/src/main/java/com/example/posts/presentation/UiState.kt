package com.example.posts.presentation

import com.example.posts.domain.PostUiModel

data class UiState(
    val posts: List<PostUiModel> = emptyList()
)