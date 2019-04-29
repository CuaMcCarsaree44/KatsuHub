package com.cua.katsuhub.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.repository.HistoryRepository
import com.cua.katsuhub.room_service.AnimeRoomDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HistoryViewModel(context: Context) : ViewModel() {
    private var repos:HistoryRepository

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
//FIXME Errornya masih ada disini
    fun insert(history:Anime)
    {
        disponsible.add(repos.Insert(history).subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).subscribe())
    }
}