package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainVIewModel(private val repository: Repository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPosts()
        }
    }

    val posts :LiveData<Response<PostsItem>>
    get() = repository.posts

}