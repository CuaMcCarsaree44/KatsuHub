package com.cua.katsuhub.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.repository.HistoryRepository
import com.cua.katsuhub.room_service.AnimeRoomDatabase
import com.cua.katsuhub.services.context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HistoryViewModel: ViewModel() {


    private var repos:HistoryRepository
    var histories: MutableLiveData<List<Anime>> = MutableLiveData()

    private val disponsible by lazy {
        CompositeDisposable()
    }

    init{
        val dao = AnimeRoomDatabase.getDatabase(context).animeDao()
        repos = HistoryRepository(dao)
        //allData.postValue(repos.allData)
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun insert(history:Anime)
    {
        disponsible.add(repos.Insert(history).subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).subscribe())
    }

    fun changeNumber(x:String):String{
        val current:Long = System.currentTimeMillis()/1000
        val numb:Long = current - x.toLong()
        return when {
            (numb / 31556926) > 0 -> (numb/31556926).toString()
            (numb / 2629743) > 0 -> (numb / 2629743).toString()
            (numb / 86400) > 0 -> (numb/86400).toString()
            (numb / 3600) > 0 -> (numb/3600).toString()
            (numb / 60) > 0 -> (numb/60).toString()
            (numb) > 0 -> (numb).toString()
            else -> ""
        }
    }

    fun changeFormat(x:String):String{
        val current:Long = System.currentTimeMillis()/1000
        val numb:Long = current - x.toLong()
        return when {
            (numb / 31556926) > 0 -> "Year"
            (numb / 2629743) > 0 -> "Month"
            (numb / 86400) > 0 -> "Day"
            (numb / 3600) > 0 -> "Hour"
            (numb / 60) > 0 -> "Minute"
            (numb) > 0 -> "Second"
            else -> "Just Now"
        }
    }

    fun getAllData(){
        //var ex:ArrayList<Anime> = ArrayList()
        disponsible.add(repos.allData().subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).subscribe {
            histories.postValue(it)
            Log.d("SIZE IT", "${it.size}")
        })
        //Log.d("SIZE", "${ex.size}")

    }

}