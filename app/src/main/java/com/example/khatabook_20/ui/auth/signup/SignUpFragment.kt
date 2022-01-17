package com.example.khatabook_20.ui.auth.signup


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
import com.example.khatabook_20.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    val binding: FragmentSignUpBinding =
        DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)


        val application = requireNotNull(this.activity).application
        val viewModelFactory= SignUpViewModelFactory(application)



        val signUpViewModel = ViewModelProvider(this,viewModelFactory).get(SignUpViewModel::class.java)


        binding.signUpViewModel=signUpViewModel

        binding.lifecycleOwner=this

        signUpViewModel.getUserData().observe(viewLifecycleOwner, Observer {
            if(it!=null){
                findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
            }
        })
        return binding.root




    }




}