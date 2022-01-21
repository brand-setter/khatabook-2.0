package com.example.khatabook_20.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.ActivityLandingBinding
import com.google.android.material.tabs.TabLayout

class Landingscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_navigation)

        var binding: ActivityLandingBinding
        = setContentView(this, R.layout.activity_landing)


        val tablayout = binding.tablayout1
        val viewpager = binding.viewpager1

        tablayout.addTab(tablayout.newTab().setText("Transactions"))
        tablayout.addTab(tablayout.newTab().setText("History"))

        tablayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPager(this, supportFragmentManager,
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