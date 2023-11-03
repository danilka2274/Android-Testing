package com.example.android_testing.impl

import com.example.android_testing.domain.GithubApi
import com.example.android_testing.domain.Repository
import com.example.android_testing.domain.entities.GithubUser

class RepositoryImpl(
    private val webApi: GithubApi
) : Repository {
    override suspend fun getUsers(): List<GithubUser> {
        return webApi.usersList()
    }
}