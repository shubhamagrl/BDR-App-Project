package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bdrapp.databinding.FragmentSplashBinding

class fragment_splash : Fragment() {

    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_splash,container,false)

        var login_btn = binding.button4
        login_btn.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_splash_to_fragment_login)
        }

        return binding.root
    }
}