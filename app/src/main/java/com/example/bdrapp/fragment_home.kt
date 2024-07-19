package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bdrapp.databinding.FragmentHomeBinding

class fragment_home : Fragment() {

    private var isOriginal: Boolean = true
    lateinit var binding: FragmentHomeBinding
    lateinit var cardContent: FrameLayout
    lateinit var card: CardView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        val profile_button: TextView = binding.idprofile
        profile_button.setOnClickListener { view ->
            showPopupMenu(view)
        }

        meter()
        displayProgress()
        first_card()

        return binding.root
    }

    fun first_card(){
        cardContent = binding.cardContent
        card = binding.cardView

        val originalContent = layoutInflater.inflate(R.layout.first_card_1, cardContent,false)
        val modifiedContent = layoutInflater.inflate(R.layout.first_card_2, cardContent, false)
        cardContent.addView(originalContent)

        card.setOnClickListener{
            cardContent.removeAllViews()
            if(isOriginal){
                cardContent.addView(originalContent)
            }
            else{
                cardContent.addView(modifiedContent)
            }
            isOriginal = !isOriginal
        }
    }
    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.profile_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            handleMenuItemClick(menuItem, view)
        }

        popupMenu.show()
    }
    private fun handleMenuItemClick(item: MenuItem, view: View): Boolean {
        return when (item.itemId) {
            R.id.option_1 -> {
                true
            }
            R.id.option_2 -> {
                Toast.makeText(requireContext(), "Add Account", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option_3 -> {
                true
            }
            else -> false
        }
    }


    fun displayProgress(){
        val progressValue = 60
        //binding.idprogressbar.progress = progressValue
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