package com.example.posts.domain

import com.example.posts.data.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(userId: Int): List<PostUiModel> {
        return postsRepository.getPosts(userId).map { entity ->
            PostUiModel(entity.userId, entity.id, entity.title, entity.body)
        }
    }
}