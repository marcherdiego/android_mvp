package com.nerdscorner.mvplib.testapp.events.networking

import retrofit2.http.GET

interface ExampleService {
    @GET("testapp/static/example.html")
    suspend fun getExamplePage(): String
}
