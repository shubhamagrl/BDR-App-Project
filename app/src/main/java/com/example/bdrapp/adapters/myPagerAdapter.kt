package com.example.bdrapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class myPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){

    private val fragmentsList = ArrayList<Fragment>()
    private val fragmentsTitleList = ArrayList<String>()
    override fun getCount(): Int {
        return fragmentsList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentsList[position]
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentsTitleList[position]
    }
    fun addFragments(fragment: Fragment, title: String){
        fragmentsList.add(fragment)
        fragmentsTitleList.add(title)
    }
}