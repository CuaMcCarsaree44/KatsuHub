package com.cua.katsuhub.adapter.fragment_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cua.katsuhub.view.fragments.menuactivity_frag.Home
import com.cua.katsuhub.view.fragments.menuactivity_frag.Profile
import com.cua.katsuhub.view.fragments.menuactivity_frag.Search
import com.cua.katsuhub.view.fragments.menuactivity_frag.Setting

class MenuActivityFragmentAdapter constructor(fm:FragmentManager, numbofTabs:Int) : FragmentStatePagerAdapter(fm) {
    private var count:Int = 0

    init{
        this.count = numbofTabs
    }

    override fun getItem(position: Int): Fragment? {
       when(position)
       {
           0 ->{
               val first_tab = Home()
               return first_tab
           }

           1 ->{
                val second_tab = Search()
               return second_tab
           }

           2->{
                val third_tab = Setting()
               return third_tab
           }

           3->{
                val fourth_tab = Profile()
               return fourth_tab
           }

           else->{
                return null
           }
       }
    }

    override fun getCount(): Int {
        return count
    }
}