package com.example.khatabook_20.ui.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var binding: FragmentProfileBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_profile,
            container,false)
        return binding.root
    }


}
