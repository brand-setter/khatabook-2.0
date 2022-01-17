package com.example.khatabook_20.database.repositories

import android.app.Activity
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository(application: Application){
private var auth: FirebaseAuth
private lateinit var application:Application
    private val firebaseUserAuthRepository= MutableLiveData<FirebaseUser?>()


    private val userLoggedAuthRepository=MutableLiveData<Boolean?>()


    init{
        this.application=application
        auth= FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
               firebaseUserAuthRepository.postValue(auth.currentUser)

        }
    }

    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser?>? {
        return firebaseUserAuthRepository
    }

    fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean?>? {
          return userLoggedAuthRepository
    }

    fun register(email:String,password:String){
        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(application, "Please enter you email address or password", Toast.LENGTH_LONG)
                .show()
            return
        }
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if(!it.isSuccessful) return@addOnCompleteListener
                    Log.d("SignUp", "${it.result?.user?.uid}")
                }

                .addOnFailureListener{
                    Toast.makeText(application, "${it.message}", Toast.LENGTH_LONG).show()
                }
    }

    fun login(email:String,password: String){
        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(application, "Please enter you email address or password", Toast.LENGTH_LONG)
                .show()
            return
        }
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if(!it.isSuccessful) return@addOnCompleteListener
                Toast.makeText(application,"Welcome back!",Toast.LENGTH_LONG).show()
            }

            .addOnFailureListener{
                Toast.makeText(application,"${it.message}",Toast.LENGTH_LONG).show()
            }
    }

    fun signOut(){
        auth.signOut()
        userLoggedAuthRepository.postValue(true)

    }




}