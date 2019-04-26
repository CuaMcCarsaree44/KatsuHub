package com.cua.katsuhub.view.fragments.menuactivity_frag


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.AnimeSearchListAdapter
import com.cua.katsuhub.adapter.TopFeaturedAdapter
import com.cua.katsuhub.databinding.FragmentSearchBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class Search : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var title:String
    private val viewModel by lazy{
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
    }

    private val adapter by lazy{
        context?.let { AnimeSearchListAdapter(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater)
        return binding.root
    }

    private fun initBinding(inflater:LayoutInflater)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, null, false)
        binding.apply{
            viewmodel = viewModel
            searchEngine.setOnKeyListener { view: View, i: Int, keyEvent: KeyEvent ->
                if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    searchResult.adapter = adapter
                    searchResult.layoutManager = LinearLayoutManager(
                        context, LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    search()
                }
                if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_BACK)
                    searchEngine.clearFocus()
                return@setOnKeyListener true
            }
        }
    }

    private fun search(){
        val nullable_context: Context? = context
        title = searchEngine.text.toString()
        if (nullable_context != null) {
            viewModel.getByTitle(title)
        }
        viewModel.searchResult.observe(this, Observer{
            adapter!!.loadList(it)
        })
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
