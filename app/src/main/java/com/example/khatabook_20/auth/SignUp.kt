package com.example.khatabook_20.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.FragmentSignUpBinding
import com.example.khatabook_20.util.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUp : Fragment() , AuthInferface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val rootView= inflater.inflate(R.layout.fragment_sign_up, container, false)

        val binding:FragmentSignUpBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)

        val viewModel= ViewModelProviders.of(this).get(KhatabookRegisterModel::class.java)

        binding.viewModel=viewModel
        viewModel.authListener=this


        return binding.root
    }
    override fun onStarted() {
        activity?.toast("Started")

    }

    override fun onSuccess() {
        activity?.toast("Success")

        }

    override fun onFailure(message:String) {
        activity?.toast(message)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}