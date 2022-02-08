package com.example.khatabook_20.home.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentHistoryBinding = DataBindingUtil.inflate(inflater,  R.layout.fragment_history,
            container,false)
        return binding.root
    }


}