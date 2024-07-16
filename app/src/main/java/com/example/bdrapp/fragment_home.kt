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
            handleMenuItemClick(menuItem)
        }

        popupMenu.show()
    }
    private fun handleMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_1 -> {
                Toast.makeText(requireContext(), "Profile", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option_2 -> {
                Toast.makeText(requireContext(), "Add Account", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option_3 -> {
                Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
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