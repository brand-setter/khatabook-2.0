package com.example.khatabook_20.auth

interface AuthInferface {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}