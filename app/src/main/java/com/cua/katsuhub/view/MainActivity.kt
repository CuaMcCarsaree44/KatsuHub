package com.cua.katsuhub.view

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.TopFeaturedAdapter
import com.cua.katsuhub.databinding.ActivityMainBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {
    private lateinit var searchAnime:EditText
    private lateinit var bind: ActivityMainBinding

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
        searchAnime = this.findViewById(R.id.searchAnime)
        searchAnime.clearFocus()
        searchAnime.onFocusChangeListener = this@MainActivity
        searchAnime.setOnKeyListener { view: View, i: Int, keyEvent: KeyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER)
                searchTrigger()
            return@setOnKeyListener true
        }
    }

    fun searchTrigger()
    {
        Toast.makeText(this@MainActivity, "LAMBDA EXPRESSION EVERYBADEH!!!!", Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when(v?.id)
        {
            R.id.searchAnime ->{
                if(hasFocus === false)
                {
                    searchAnime.typeface = default
                }else if(hasFocus === true)
                {
                    searchAnime.typeface = calibri
                }
            }   
        }
    }
}
