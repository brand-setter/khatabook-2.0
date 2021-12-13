package com.example.khatabook_20

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.khatabook_20.databinding.ActivityAuthBinding
import com.google.android.material.tabs.TabLayout

class Auth:AppCompatActivity() {

        private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

//        val DialogView= LayoutInflater.from(this).inflate(R.layout.activity_auth,null)
//
//        val Builder= AlertDialog.Builder(this).setView(DialogView).setTitle("Login Form")
//
//        val alertDialog=Builder.show()
       val tablayout = binding.tablayout
        val viewpager = binding.viewpager
        tablayout.addTab(tablayout.newTab().setText("SignIn"))
        tablayout.addTab(tablayout.newTab().setText("SignUp"))
        tablayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = ViewPagerAdapter(this, supportFragmentManager,
            tablayout.tabCount)
        viewpager.adapter = adapter

        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}




