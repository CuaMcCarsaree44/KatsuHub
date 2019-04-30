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
import com.cua.katsuhub.repository.HistoryRepository
import com.cua.katsuhub.room_service.AnimeDao
import com.cua.katsuhub.services.AnimeRepository
import com.cua.katsuhub.services.context
import com.cua.katsuhub.viewmodel.AnimeViewModel
import com.cua.katsuhub.viewmodel.DetailActivityViewModel
import com.cua.katsuhub.viewmodel.HistoryViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

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

        bind = DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)
        bind.apply{
            loadresources = this@DetailActivity.viewModel
            ratingsystem = this@DetailActivity.viewDetailModel

        }
    }

    private fun insertToDB(history:Anime){
        context = this@DetailActivity
        val repos: HistoryViewModel = HistoryViewModel()
        repos.insert(history)
    }

    private fun execute()
    {
        lateinit var history: Anime
        val get: Intent = intent
        val id:Int = get.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
        viewModel.getSpecific(id)
        viewModel.anime.observe(this, Observer {
            bind.anime = it
            history = Anime(it!!.id, it.attributes.posterImage.tiny,
                it.attributes.titles.jp, (System.currentTimeMillis()/1000).toString())
            insertToDB(history)
        })

    }
}
