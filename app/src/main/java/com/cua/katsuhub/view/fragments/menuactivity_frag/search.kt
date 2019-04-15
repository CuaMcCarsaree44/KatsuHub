package com.cua.katsuhub.view.fragments.menuactivity_frag


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.cua.katsuhub.R
import com.cua.katsuhub.databinding.FragmentSearchBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Search : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private val viewModel by lazy{
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
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

        }
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
