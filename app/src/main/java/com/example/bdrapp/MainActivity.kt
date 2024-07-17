package com.example.bdrapp

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.bdrapp.adapters.myPagerAdapter
import com.example.bdrapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewPager2: ViewPager2
    lateinit var adapter: myPagerAdapter
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setup()
        tabSelection()
    }


    fun setup(){
        viewPager2 = findViewById(R.id.id_viewPager2)
        adapter = myPagerAdapter(this)
        viewPager2.adapter = adapter

        // Set up TabLayout with ViewPager
        tabLayout = findViewById(R.id.idtablayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Bill"
                2 -> tab.text = "Events"
                3 -> tab.text = "Help"
            }
        }.attach()
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = getTabView(i)
        }
    }

    fun tabSelection(){
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.id_tab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.id_tab_text)

                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.selectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.selectedColor))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.id_tab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.id_tab_text)

                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null)
        val tabIcon: ImageView = view.findViewById(R.id.id_tab_icon)
        val tabTitle: TextView = view.findViewById(R.id.id_tab_text)

        when (position) {
            0 -> {
                tabIcon.setImageResource(R.drawable.home_icon)
                tabTitle.text = "Home"
            }

            1 -> {
                tabIcon.setImageResource(R.drawable.bill_icon)
                tabTitle.text = "Bill"
            }

            2 -> {
                tabIcon.setImageResource(R.drawable.events_icon)
                tabTitle.text = "Events"
            }

            3 -> {
                tabIcon.setImageResource(R.drawable.help_icon)
                tabTitle.text = "Help"
            }
        }
        return view
    }
}