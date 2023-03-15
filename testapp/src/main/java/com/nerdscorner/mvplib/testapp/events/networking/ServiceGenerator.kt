package com.nerdscorner.mvplib.testapp.events.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceGenerator {
    private const val BASE_URL = "https://raw.githubusercontent.com/marcherdiego/android_mvp/develop/"

    private var retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                })
                .build()
        )
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    fun <T> createService(clazz: Class<T>): T = retrofit.create(clazz)
}
