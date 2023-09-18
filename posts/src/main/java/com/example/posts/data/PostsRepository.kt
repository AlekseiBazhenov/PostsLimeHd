package com.example.posts.data

import com.example.db.entities.PostEntity

interface PostsRepository {
    suspend fun getPosts(userId: Int): List<PostEntity>
}