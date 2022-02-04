package com.example.khatabook_20.auth.signin

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.khatabook_20.database.repositories.AuthRepository
import com.google.firebase.auth.FirebaseUser

class SignInViewModel(application: Application):ViewModel(){
     private var authRepository:AuthRepository
     val firebaseUser:LiveData<FirebaseUser?>
          get()=authRepository.getFirebaseUserMutableLiveData()

     init{
          authRepository= AuthRepository(application)
     }

     fun register(email:String,password:String){
          authRepository.register(email, password)

     }
}