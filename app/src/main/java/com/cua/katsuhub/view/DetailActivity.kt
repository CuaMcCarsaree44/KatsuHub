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
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.viewmodel.AnimeViewModel
import com.cua.katsuhub.viewmodel.DetailActivityViewModel
import com.cua.katsuhub.viewmodel.HistoryViewModel

class DetailActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_VIEW_PRIMARY_KEY:String = "DATA"
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

    //TODO 3.0 - Saving Data. I save data from here
    private fun initBinding()
    {
        val savedata:HistoryViewModel = HistoryViewModel(application)
        lateinit var history:Anime
        bind = DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)
        bind.apply{
            loadresources = this@DetailActivity.viewModel
            ratingsystem = this@DetailActivity.viewDetailModel
            history = Anime(anime!!.links.self, anime!!.attributes.posterImage.tiny!!
                , anime!!.attributes.titles!!.jp!!, (System.currentTimeMillis()/1000).toString())
        }
    }

    private fun execute()
    {
        val get: Intent = intent
        val id:Int = get.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
        viewModel.getSpecific(id)
        viewModel.anime.observe(this, Observer {
            bind.anime = it
        })

    }
}
