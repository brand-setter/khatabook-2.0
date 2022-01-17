package com.example.khatabook_20.ui.auth.signup


import android.content.Intent
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
import com.example.khatabook_20.database.KhataBook
import com.example.khatabook_20.databinding.FragmentSignUpBinding
import com.example.khatabook_20.landingscreen


class SignUpFragment : Fragment() {
    private var khatabook:KhataBook=KhataBook("","","")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val binding: FragmentSignUpBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory= SignUpViewModelFactory(application)
        val signUpViewModel = ViewModelProvider(this,viewModelFactory).get(SignUpViewModel::class.java)

        binding.signUpViewModel=signUpViewModel
        binding.khatabook=khatabook
        binding.lifecycleOwner=this

        signUpViewModel.firebaseUser.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                val intent= Intent(application, landingscreen::class.java)
                startActivity(intent)
            }
        })
        return binding.root
    }




}