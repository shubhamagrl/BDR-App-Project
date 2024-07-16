package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bdrapp.databinding.FragmentHomeBinding

class fragment_home : Fragment() {
    
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        val profile_button: TextView = binding.idgreeting
        profile_button.setOnClickListener { view ->
            showPopupMenu(view)
        }

        meter()
        displayProgress()

        return binding.root
    }


    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.menuInflater.inflate(R.menu.profile_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            handleMenuItemClick(menuItem, view)
        }

        popupMenu.show()
    }
    private fun handleMenuItemClick(item: MenuItem, view: View): Boolean {
        return when (item.itemId) {
            R.id.option_1 -> {
                view.findNavController().navigate(R.id.action_fragment_home3_to_fragment_profile)
                true
            }
            R.id.option_2 -> {
                view.findNavController().navigate(R.id.action_fragment_home3_to_fragment_add_account)
                true
            }
            R.id.option_3 -> {
                view.findNavController().navigate(R.id.action_fragment_home3_to_fragment_login)
                true
            }
            else -> false
        }
    }


    fun displayProgress(){
        val progressValue = 60
        binding.idprogressbar.progress = progressValue
    }
    fun meter(){
        var arr = listOf(R.drawable.connected, R.drawable.disconnected)
        var index = 0

        binding.apply {
            idmeter.setOnClickListener {
                index = (index + 1) % 2
                idmeter.setImageResource(arr[index])
            }
        }
    }
}