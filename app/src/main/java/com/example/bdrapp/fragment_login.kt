package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bdrapp.databinding.FragmentLoginBinding

class fragment_login : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var login_button: Button
    lateinit var create_button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        login_button = binding.idLoginButton
        create_button = binding.idLoginCreate


        return binding.root
    }
}