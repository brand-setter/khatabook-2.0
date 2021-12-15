package com.example.khatabook_20.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel


class KhatabookRegisterModel: ViewModel() {
    var username:String?=null
    var email:String?=null
    var password:String?=null

   var authListener: AuthInferface?=null

    fun onLoginButtonClicked(view: View){
      authListener?.onStarted()
      Log.d("Priya","${email.toString()}")
        if(email.isNullOrEmpty()|| password.isNullOrEmpty()){
           authListener?.onFailure("Invalid Email and Password")
            return
        }
        authListener?.onSuccess()


    }

}