package com.nerdscorner.mvplib.testapp.events.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleService {
    @GET("testapp/static/example.html")
    suspend fun getExamplePage(): String
    
    @GET("testapp/static/example.html")
    suspend fun getExamplePageWithParams(@Query("key") value: String): String
}
