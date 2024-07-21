package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bdrapp.databinding.FragmentAddAccountBinding

class fragment_add_account : Fragment() {

    lateinit var binding: FragmentAddAccountBinding
    lateinit var create: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_account,container,false)

        binding.idCreateButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_add_account_to_fragment_login)
        }

        return binding.root
    }
}