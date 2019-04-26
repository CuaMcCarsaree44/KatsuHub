package com.cua.katsuhub.adapter.fragment_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cua.katsuhub.R
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
       lateinit var tab:Fragment
        when(position)
       {
           0 ->{
               tab = Home()
           }

           1 ->{
                tab = Search()
           }

           2->{
                tab = Setting()
           }

           3->{
                tab = Profile()
           }

           else-> {}
       }
        return tab
    }

    override fun getCount(): Int {
        return count
    }
}