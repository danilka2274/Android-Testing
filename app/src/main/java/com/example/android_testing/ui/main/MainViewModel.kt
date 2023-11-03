package com.example.android_testing.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_testing.domain.Repository
import com.example.android_testing.domain.entities.GithubUser
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: Repository
) : ViewModel() {
    private var liveData: MutableLiveData<List<GithubUser>> = MutableLiveData()
    val openLiveData: LiveData<List<GithubUser>> = liveData

    fun getData() {
        viewModelScope.launch {
            liveData.value = repo.getUsers()
        }
    }
}