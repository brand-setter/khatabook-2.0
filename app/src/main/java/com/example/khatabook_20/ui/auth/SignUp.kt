package com.example.khatabook_20.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.khatabook_20.R
import com.example.khatabook_20.databinding.FragmentSignUpBinding
import com.example.khatabook_20.ui.auth.AuthInferface
import com.example.khatabook_20.ui.auth.KhatabookRegisterModel
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
     private lateinit var viewModel:KhatabookRegisterModel
     private lateinit var binding:FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val rootView= inflater.inflate(R.layout.fragment_sign_up, container, false)

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)




        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel= ViewModelProviders.of(this).get(KhatabookRegisterModel::class.java)
        binding.viewModel=viewModel
        viewModel.authListener=this


//        binding.

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
        const val TAG = "MainFragment"
        const val SIGN_IN_RESULT_CODE = 1001
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