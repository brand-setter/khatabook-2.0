package com.example.khatabook_20

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.khatabook_20.auth.SignIn
import com.example.khatabook_20.auth.SignUp

class ViewPagerAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SignIn()
            }
            1 -> {
                SignUp()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}

