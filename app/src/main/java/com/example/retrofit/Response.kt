package com.example.retrofit

sealed class Response<T>(val data: T? = null, val errorMgs: String? = null)
{
    class Loading<T> : Response<T>()
    class Success<T>(data: T?) : Response<T>(data = data)
    class ErrorMessage<T>(mgs:String): Response<T>(errorMgs = mgs)
}
