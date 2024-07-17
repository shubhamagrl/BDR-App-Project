package com.example.bdrapp

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.bdrapp.adapters.myPagerAdapter
import com.example.bdrapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var myAdapter: myPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setup()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.idtab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.idtab_title)

                // Change color when tab is selected
                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.selectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.selectedColor))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.idtab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.idtab_title)

                // Revert color when tab is unselected
                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
    fun setup(){
        viewPager = findViewById(R.id.idviewPager)
        tabLayout = findViewById(R.id.idtablayout)

        myAdapter = myPagerAdapter(supportFragmentManager)
        myAdapter.addFragments(fragment_home(), "Home")
        myAdapter.addFragments(fragment_bill(), "Bill")
        myAdapter.addFragments(fragment_events(), "Program")
        myAdapter.addFragments(fragment_help(), "Help")

        viewPager.adapter = myAdapter
        tabLayout.setupWithViewPager(viewPager)

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = getTabView(i)
        }

    }
    fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null)
        val tabIcon: ImageView = view.findViewById(R.id.idtab_icon)
        val tabTitle: TextView = view.findViewById(R.id.idtab_title)

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