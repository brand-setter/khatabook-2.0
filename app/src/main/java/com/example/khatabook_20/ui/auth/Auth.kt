package com.example.khatabook_20.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.ActivityAuthBinding
import com.google.android.material.tabs.TabLayout

class Auth: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

           supportActionBar!!.hide()
        var binding: ActivityAuthBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_auth)


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




