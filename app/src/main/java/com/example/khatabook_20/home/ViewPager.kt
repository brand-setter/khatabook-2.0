package com.example.khatabook_20.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.khatabook_20.home.history.HistoryFragment
import com.example.khatabook_20.home.transactions.TransactionsFragment



class ViewPager (var context: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TransactionsFragment()
            }
            1 -> {
                HistoryFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
