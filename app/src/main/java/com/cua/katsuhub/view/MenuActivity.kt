package com.cua.katsuhub.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.fragment_adapter.MenuActivityFragmentAdapter
import com.cua.katsuhub.view.fragments.menuactivity_frag.Home
import com.cua.katsuhub.view.fragments.menuactivity_frag.Profile
import com.cua.katsuhub.view.fragments.menuactivity_frag.Search
import com.cua.katsuhub.view.fragments.menuactivity_frag.Setting
import com.google.android.material.tabs.TabLayout

class MenuActivity : AppCompatActivity() , Home.OnFragmentInteractionListener, Profile.OnFragmentInteractionListener,
Setting.OnFragmentInteractionListener, Search.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    private lateinit var tabs: TabLayout
    private lateinit var viewpage:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tabs = findViewById(R.id.tabLayoutMenu)
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_home_black_24dp))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_search_black_24dp))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_settings_black_24dp))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_person_black_24dp))
        tabs.tabGravity = TabLayout.GRAVITY_FILL

        viewpage = findViewById(R.id.menuViewPager)

        val adapter = MenuActivityFragmentAdapter(supportFragmentManager, tabs.tabCount)

        viewpage.adapter = adapter
        viewpage.setOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.setOnTabSelectedListener(object:TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                viewpage.currentItem = p0!!.position
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewpage.currentItem = p0!!.position
            }

        })
    }
}
