package com.example.bdrapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bdrapp.databinding.FragmentHomeBinding
import org.w3c.dom.Text

class fragment_home : Fragment() {

    private var isOriginal: Boolean = true
    lateinit var binding: FragmentHomeBinding
    lateinit var cardContent: FrameLayout
    lateinit var first_card: CardView
    lateinit var second_card: CardView
    lateinit var reg_btn: Button
    lateinit var ign_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        profile_menu()
        meter()
        displayProgress()
        first_card()
        myActivity_spinner()
        ignore_btn()

        return binding.root
    }

    fun ignore_btn(){
        ign_btn = binding.button3
        second_card = binding.cardView2

        ign_btn.setOnClickListener{
            second_card.visibility = View.GONE
        }
    }
    fun myActivity_spinner(){
        var mySpinner: Spinner = binding.spinner
        var text1: TextView = binding.textView11
        var text2: TextView = binding.textView15
        var text3: TextView = binding.textView20

        val arr = arrayOf("Today", "Yesterday")
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,arr)

        mySpinner.adapter = adapter

        mySpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position == 0){
                    text1.text = "Units Consumed: 14"
                    text2.text = "Units Saved: 0"
                    text3.text = "Participated in 0 events today"
                }
                else{
                    text1.text = "Units Consumed: 35"
                    text2.text = "Units Saved: 4"
                    text3.text = "Participated in 1 event yesterday"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    fun first_card(){
        cardContent = binding.cardContent
        first_card = binding.cardView

        val originalContent = layoutInflater.inflate(R.layout.first_card_1, cardContent,false)
        val modifiedContent = layoutInflater.inflate(R.layout.first_card_2, cardContent, false)
        cardContent.addView(originalContent)

        first_card.setOnClickListener{
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

    fun profile_menu(){
        val profile_button: TextView = binding.idprofile
        profile_button.setOnClickListener { view ->
            showPopupMenu(view)
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
    fun handleMenuItemClick(item: MenuItem, view: View): Boolean {
        return when (item.itemId) {
            R.id.option_1 -> {
                Toast.makeText(requireContext(), "Profile", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option_2 -> {
                Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
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