package com.example.bdrapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class myPagerAdapter(fm: FragmentManager, lc: Lifecycle): FragmentStateAdapter(fm,lc){

    var FragmentsList: ArrayList<Fragment> = ArrayList()

    fun addFragments(fragment: Fragment){
        FragmentsList.add(fragment)
    }
    override fun getItemCount(): Int {
        return FragmentsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentsList.get(position)
    }
}