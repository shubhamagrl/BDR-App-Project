package com.example.bdrapp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.bdrapp.adapters.myPagerAdapter
import com.example.bdrapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewPager2: ViewPager2
    lateinit var adapter: myPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.id_viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        adapter = myPagerAdapter(supportFragmentManager, lifecycle)

        adapter.addFragments(fragment_login())
        adapter.addFragments(fragment_bill())
        adapter.addFragments(fragment_events())
        adapter.addFragments(fragment_help())

        viewPager2.adapter = adapter

    }
}