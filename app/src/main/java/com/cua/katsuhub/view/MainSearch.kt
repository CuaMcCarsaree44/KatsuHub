package com.cua.katsuhub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.AnimeSearchListAdapter
import com.cua.katsuhub.databinding.ActivityMainSearchBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_main_search.*

class MainSearch : AppCompatActivity() {
    private lateinit var bind:ActivityMainSearchBinding
    private lateinit var title:String

    private val viewModel by lazy{
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
    }

    private val adapter by lazy{
        AnimeSearchListAdapter(this@MainSearch)
    }

    companion object{
        const val PRIMARY_KEY_TITLE:String = "Title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        showAll()
    }

    private fun initBinding()
    {
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main_search)
        bind.apply{
            viewmodel = this@MainSearch.viewModel
            recyclerView_SearchResult.adapter = adapter
            recyclerView_SearchResult.layoutManager = LinearLayoutManager(this@MainSearch,
                    RecyclerView.VERTICAL, false)
        }

    }

    private fun showAll()
    {
        title = intent.getStringExtra(PRIMARY_KEY_TITLE)
        viewModel.getByTitle(title, this@MainSearch)
        viewModel.searchResult.observe(this, Observer{
            adapter.loadList(it)
        })
    }
}
