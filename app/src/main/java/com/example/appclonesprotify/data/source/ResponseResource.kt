package com.example.appclonesprotify.data.source


 abstract class  ResponseResource{
    class Success<T>(val data: T) : ResponseResource()
    class Error<T>(val exception: Exception) : ResponseResource()
}