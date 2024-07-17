package com.example.bdrapp.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bdrapp.fragment_bill
import com.example.bdrapp.fragment_events
import com.example.bdrapp.fragment_help
import com.example.bdrapp.fragment_home
class myPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragment_home()
            1 -> fragment_bill()
            2 -> fragment_events()
            3 -> fragment_help()
            else -> fragment_home()
        }
    }
}

