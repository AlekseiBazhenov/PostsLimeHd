package com.example.network

import com.example.network.responses.Post
import com.example.network.responses.User
import retrofit2.http.GET

interface BackendApi {

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/posts")
    suspend fun getPosts(): List<Post>

}