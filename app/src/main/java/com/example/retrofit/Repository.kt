package com.example.retrofit

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import java.lang.Exception

class Repository(private val retrofitService: RetrofitService) {
    private val postLiveData= MutableLiveData<com.example.retrofit.Response<PostsItem>>()

    val posts :LiveData<com.example.retrofit.Response<PostsItem>>
    get() = postLiveData

    suspend fun getPosts(){
        val result= retrofitService.getPost()
        try {
            if (result?.body() != null){
                postLiveData.postValue(com.example.retrofit.Response.Success(result.body()))
            }
        }catch (e:Exception){
            postLiveData.postValue(com.example.retrofit.Response.ErrorMessage(e.message.toString()))
        }

    }
}