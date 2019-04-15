package com.cua.katsuhub.view
//FIXME - Jangan Lupa bikin Pointer buat ngesave Page yang udah di datengin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cua.katsuhub.R
import com.cua.katsuhub.databinding.ActivityDetailBinding
import com.cua.katsuhub.viewmodel.AnimeViewModel
import com.cua.katsuhub.viewmodel.DetailActivityViewModel
class DetailActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_VIEW_PRIMARY_KEY:String = "DATA"
        const val CURRENT_LINKS:String = "LINKS"
    }

    private lateinit var bind: ActivityDetailBinding

    private val viewModel by lazy{
        ViewModelProviders.of(this).get(AnimeViewModel::class.java)
    }

    private val viewDetailModel by lazy{
        ViewModelProviders.of(this).get(DetailActivityViewModel::class.java)
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
            loadresources = this@DetailActivity.viewModel
            ratingsystem = this@DetailActivity.viewDetailModel
        }
    }

    private fun execute()
    {
        val get: Intent = intent
        val id:Int = get.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
        val links:String = get.getStringExtra(CURRENT_LINKS)
        viewModel.getSpecific(id)
        viewModel.anime.observe(this, Observer {
            bind.anime = it
        })

    }
}
