package com.example.khatabook_20.ui.auth.signin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val binding: FragmentSignInBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_sign_in,container,false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory=SignInViewModelFactory(application)


        val signInViewModel = ViewModelProvider(this,viewModelFactory).get(SignInViewModel::class.java)

        binding.signInViewModel=signInViewModel

        binding.lifecycleOwner=this

        signInViewModel.getUserData().observe(viewLifecycleOwner, Observer {
            if(it!=null){
                findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
            }
        })
        return binding.root
    }


}