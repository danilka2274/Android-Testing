package com.example.android_testing.domain

import com.example.android_testing.domain.entities.GithubUser

interface Repository {
    suspend fun getUsers(): List<GithubUser>
}