package com.cua.katsuhub.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.SearcListAdapter
import com.cua.katsuhub.databinding.ActivitySearchResultBinding
import com.cua.katsuhub.viewmodel.CharacterViewModel

class SearchResult : AppCompatActivity() {

    private lateinit var bind: ActivitySearchResultBinding

    private val adapter by lazy {
        SearcListAdapter()
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    companion object {
        const val CHARACTER_PRIMARY_KEY:String = "Character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        getSearchData()
    }

    private fun initBinding(){
        bind = DataBindingUtil.setContentView(this, R.layout.activity_search_result)
        bind.apply {
            viewModel = this@SearchResult.viewModel
            recylerView.adapter = adapter
            recylerView.layoutManager = LinearLayoutManager(this@SearchResult)
        }
    }

    private fun getSearchData()
    {
        val search = intent.getStringExtra(CHARACTER_PRIMARY_KEY)
        viewModel.getCharacter(search)
        viewModel.character.observe(this, Observer {
            adapter.loadChars(it)
        })
    }
}
