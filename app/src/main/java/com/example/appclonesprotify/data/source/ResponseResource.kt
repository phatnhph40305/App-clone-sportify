package com.example.appclonesprotify.data.source

import java.lang.Exception


abstract class ResponseResource {
    class Success<T>(val data: T) : ResponseResource()
    class ErrorResponse (val exception: Exception) : ResponseResource()
}