package com.cua.katsuhub.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cua.katsuhub.R
import com.cua.katsuhub.adapter.HistoryAdapter
import com.cua.katsuhub.databinding.ActivityHistoryBinding
import com.cua.katsuhub.viewmodel.HistoryViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHistoryBinding

    private val viewModel by lazy{
        ViewModelProviders.of(this).get(HistoryViewModel::class.java)
    }

    private val disposable = CompositeDisposable()

    private val adapter by lazy{
        HistoryAdapter(this@HistoryActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        showAll()
    }

    @SuppressLint("WrongConstant")
    private fun initialBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)
        binding.apply{
            viewmodel = viewModel
            historyRecyclerView.adapter = adapter
            historyRecyclerView.layoutManager = LinearLayoutManager(this@HistoryActivity,
                LinearLayout.VERTICAL, true)
        }
    }

    private fun showAll(){
        disposable.add(viewModel.getAllData(). subscribeOn(Schedulers.io())
        viewModel.histories.observe(this, Observer{
            adapter.loadHistory(it)
        })
    }
}
