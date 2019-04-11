package com.cua.katsuhub.view.fragments.menuactivity_frag

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cua.katsuhub.R
import android.net.Uri
import androidx.databinding.DataBindingUtil
import com.cua.katsuhub.databinding.FragmentHomeBinding
import com.cua.katsuhub.view.MainActivity
import com.cua.katsuhub.view.MainMenu

class Home : Fragment(), View.OnClickListener {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        initialBinding(inflater)
        return binding.root
    }

    private fun initialBinding(inflater:LayoutInflater)
    {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, null, false)
        binding.apply {
            mainMenuTile.setOnClickListener(this@Home)
            searchCharacterTile.setOnClickListener(this@Home)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.mainMenuTile -> {
                context!!.startActivity(Intent(context, MainActivity::class.java))
            }

            R.id.searchCharacterTile ->{
                context!!.startActivity(Intent(context, MainMenu::class.java))
            }
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
