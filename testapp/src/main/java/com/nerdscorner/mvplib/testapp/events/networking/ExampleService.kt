package com.nerdscorner.mvplib.testapp.events.networking

import retrofit2.http.GET

interface ExampleService {
    @GET("wiki/Wikipedia")
    suspend fun getWikipedia(): String
}
