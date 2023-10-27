package com.example.android_testing.presenter.search

import com.example.android_testing.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
}