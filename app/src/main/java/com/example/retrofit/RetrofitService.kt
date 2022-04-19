package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/users")
    suspend fun getPost():Response<PostsItem>
}