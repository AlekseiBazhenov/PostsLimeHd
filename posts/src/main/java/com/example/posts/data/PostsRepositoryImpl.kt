package com.example.posts.data

import com.example.db.PostDao
import com.example.db.entities.PostEntity
import com.example.network.BackendApi
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: BackendApi,
    private val postDao: PostDao
): PostsRepository {
    override suspend fun getPosts(userId: Int): List<PostEntity> {
        return try {
            val response = api.getPosts()
            val entities = response.map { post ->
                PostEntity(post.id, post.userId, post.title, post.body)
            }
            postDao.clear()
            postDao.insertAll(entities)
            entities.filter { it.userId == userId }
        } catch (e: Exception) {
            postDao.findByUserId(userId)
        }
    }
}