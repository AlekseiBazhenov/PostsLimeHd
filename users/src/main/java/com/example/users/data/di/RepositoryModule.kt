package com.example.users.data.di

import com.example.users.data.UsersRepository
import com.example.users.data.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindUsersRepository(repository: UsersRepositoryImpl): UsersRepository
}