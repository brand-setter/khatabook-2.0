package com.example.khatabook_20


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook_20.auth.Auth
import com.google.firebase.auth.FirebaseAuth


class Splash_bg : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uid= FirebaseAuth.getInstance().uid
        if(uid==null) {
            val intent = Intent(this, Auth::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(this, Landingscreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}
