package com.example.listrepositories.di.modules

import com.example.listrepositories.api.PullsRepoApi
import com.example.listrepositories.api.UserRepoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


var apiModule = module {

    single {
        provideUserApi()
    }
    single {
        providePullApi()
    }
}

fun provideUserApi(): UserRepoApi {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
    client.addInterceptor(logging)


    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())
        .build().create(UserRepoApi::class.java)
}

fun providePullApi(): PullsRepoApi {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
    client.addInterceptor(logging)


    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())
        .build().create(PullsRepoApi::class.java)
}

