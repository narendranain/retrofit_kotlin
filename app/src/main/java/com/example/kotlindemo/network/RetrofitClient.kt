package com.example.kotlindemo.network

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private const val BASE_URL = "https://api.gpsstoryteller.com/user/"


    val instance: RetroServices by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RetroServices::class.java)
    }

}