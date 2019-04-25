package com.cua.katsuhub.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.repository.HistoryRepository
import com.cua.katsuhub.room_service.AnimeRoomDatabase

class HistoryViewModel(context: Context) : ViewModel() {
    private var repos:HistoryRepository

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
        repos.Insert(history)
    }
}