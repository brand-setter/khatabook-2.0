package com.example.khatabook_20.ui.auth.signin

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khatabook_20.database.repositories.AuthRepository
import com.google.firebase.auth.FirebaseUser

class SignInViewModel(application: Application):ViewModel(){
     private lateinit var authRepository:AuthRepository

     private var firebaseUser= MutableLiveData<FirebaseUser?>()


     fun getUserData():MutableLiveData<FirebaseUser?>{
       return firebaseUser
     }


     init{
          authRepository= AuthRepository(application)
          firebaseUser= authRepository.getFirebaseUserMutableLiveData()!!

     }

     fun register(email:String,password:String){

          authRepository.register(email, password)
     }





}