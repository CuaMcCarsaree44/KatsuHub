package com.cua.katsuhub.view

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.TopFeaturedAdapter
import com.cua.katsuhub.databinding.ActivityMainBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {
    private lateinit var bind: ActivityMainBinding
    private lateinit var searchText:String
    private val adapter by lazy{ TopFeaturedAdapter(this@MainActivity) }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var calibri:Typeface

    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var default:Typeface
    
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        initBinding()
        showAll()
        calibri = resources.getFont(R.font.calibri)
        default = resources.getFont(R.font.neofobia_regular)

        searchUtils()
    }

    private fun showAll()
    {
        viewModel.getTrending()
        viewModel.animes.observe(this, Observer{
            adapter.loadList(it)
        })
    }

    private fun initBinding()
    {
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bind.apply {
            loadFeatured = this@MainActivity.viewModel
            featuredAnime.adapter = adapter
            featuredAnime.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false)
        }
    }

    private fun searchUtils()
    {
        //searchAnime = this.findViewById(R.id.searchAnime)
        searchText = searchAnime.text.toString()

        searchAnime.clearFocus()
        searchAnime.onFocusChangeListener = this@MainActivity
        searchAnime.setOnKeyListener { _: View, i: Int, keyEvent: KeyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER)
                searchTrigger()

            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_BACK)
                lostFocus()
            return@setOnKeyListener true
        }
    }

    private fun lostFocus()
    {
        searchAnime.clearFocus()
    }

    private fun searchTrigger()
    {
        val intent = Intent(this@MainActivity, MainSearch::class.java)
        intent.putExtra(MainSearch.PRIMARY_KEY_TITLE, searchText)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when(v?.id)
        {
            R.id.searchAnime ->{
                if(!hasFocus)
                {
                    searchAnime.typeface = default
                }else if(hasFocus)
                {
                    searchAnime.typeface = calibri
                }
            }   
        }
    }
}
