package com.example.android_testing.repository

import com.example.android_testing.model.SearchResponse
import retrofit2.Response

interface RepositoryCallback {
    fun handleGitHubResponse(response: Response<SearchResponse?>?)
    fun handleGitHubError()
}