package com.cua.katsuhub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val get: Intent = intent
        val id:Int = get.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
        Toast.makeText(this@DetailActivity, id.toString(), Toast.LENGTH_LONG).show()
        viewModel.getSpecific(id)
        viewModel.anime.observe(this, Observer {
            bind.anime = it
        })

    }
}
