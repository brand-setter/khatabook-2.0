package com.example.khatabook_20.auth

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.example.khatabook_20.auth.signin.SignInFragment
import com.example.khatabook_20.auth.signup.SignUpFragment


class ViewPagerAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {

             SignUpFragment()
            }
            1 -> {

                SignInFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}


