package com.example.khatabook_20

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.example.khatabook_20.ui.auth.signin.SignInFragment
import com.example.khatabook_20.ui.auth.signup.SignUpFragment


class ViewPagerAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {

                SignInFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}


