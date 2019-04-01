package com.cua.katsuhub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cua.katsuhub.R
import com.cua.katsuhub.databinding.ActivityDetailBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel

class DetailActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_VIEW_PRIMARY_KEY:String = "DATA"
    }

    private lateinit var bind: ActivityDetailBinding



    private val viewModel by lazy{
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
    }

    private val id by lazy{
        intent.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

        execute()
    }

    private fun initBinding()
    {
        bind = DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)
        bind.apply{
            loadResources = this@DetailActivity.viewModel
        }
    }

    private fun execute()
    {
        viewModel.getSpecific(id)
        viewModel.anime.observe(this, Observer {

        })

    }
}
