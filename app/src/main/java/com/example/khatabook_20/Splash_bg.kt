package com.example.khatabook_20


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook_20.auth.Auth


class Splash_bg : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent= Intent(this, Auth::class.java)
        startActivity(intent)
        finish()
    }
}
