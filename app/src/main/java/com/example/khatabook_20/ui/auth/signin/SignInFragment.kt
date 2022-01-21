package com.example.khatabook_20.ui.auth.signin


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import com.example.khatabook_20.R
import com.example.khatabook_20.database.KhataBook
import com.example.khatabook_20.databinding.FragmentSignInBinding
import com.example.khatabook_20.ui.home.Landingscreen

class SignInFragment : Fragment() {
private var khatabook:KhataBook=KhataBook("","","")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val binding: FragmentSignInBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_sign_in,container,false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory=SignInViewModelFactory(application)
        val signInViewModel = ViewModelProvider(this,viewModelFactory).get(SignInViewModel::class.java)

        binding.signInViewModel=signInViewModel
        binding.khatabook=khatabook
        binding.lifecycleOwner=this

        signInViewModel.firebaseUser.observe(viewLifecycleOwner, Observer{
            if(it!=null){
               val intent= Intent(application, Landingscreen::class.java)
                startActivity(intent)
            }
        })

        return binding.root
    }


}