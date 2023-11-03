package com.example.android_testing.domain

import com.example.android_testing.domain.entities.GithubUser
import retrofit2.http.GET


interface GithubApi {
    @GET("users")
    suspend fun usersList(): List<GithubUser>
}