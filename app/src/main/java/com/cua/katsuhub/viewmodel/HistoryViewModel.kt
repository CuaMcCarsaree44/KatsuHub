package com.cua.katsuhub.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.repository.HistoryRepository
import com.cua.katsuhub.room_service.AnimeRoomDatabase
import kotlinx.coroutines.experimental.*
//FIXME - Why is this error?
import kotlinx.coroutines.experimental.android.Main

//TODO 2.9 - Create Special ViewModel
class HistoryViewModel(app: Application) : AndroidViewModel(app) {
    //TODO 2.13 - I'm Seriously don't even understand what is this. But it has something to do with Coroutines
    private var parentJob = Job()
    private val coroutineContext: kotlin.coroutines.experimental.CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    //TODO 2.10 Define Repository References
    private val repos:HistoryRepository

    //TODO 2.11 Define a variable to cache all datas
    val allData: LiveData<List<Anime>>

    //TODO 2.12 Initialize Repository and Cache
    init{
        val dao = AnimeRoomDatabase.getDatabase(app).animeDao()
        repos = HistoryRepository(dao)
        allData = repos.allData
    }

    //TODO 2.14 - On ViewModel destroy
    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    //TODO 2.15 - Create Insert Method
    fun insert(history:Anime) = scope.launch(Dispatchers.IO)
    {
        repos.Insert(history)
    }
}