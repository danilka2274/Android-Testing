package com.example.android_testing.di


import com.example.android_testing.App
import com.example.android_testing.domain.GithubApi
import com.example.android_testing.domain.Repository
import com.example.android_testing.impl.RepositoryImpl
import com.example.android_testing.ui.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var appModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
            .build()
    }
    single<GithubApi> {
        Retrofit.Builder()
            .baseUrl(App.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GithubApi::class.java)
    }
    single<Repository> { RepositoryImpl(webApi = get()) }
    viewModel { MainViewModel(repo = get()) }
}