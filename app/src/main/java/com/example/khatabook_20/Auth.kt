package com.example.khatabook_20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Auth:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        supportActionBar!!.hide()

       val tablayout = findViewById<TabLayout>(R.id.tablayout)
        val viewpager = findViewById<ViewPager>(R.id.viewpager)
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




