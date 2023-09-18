package com.example.posts.data.di

import com.example.posts.data.PostsRepository
import com.example.posts.data.PostsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindPostsRepository(repository: PostsRepositoryImpl): PostsRepository
}