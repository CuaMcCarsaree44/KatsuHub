package com.cua.katsuhub.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.room_service.AnimeDao

//TODO 2.7 Create Repository for History
class HistoryRepository(private val dao:AnimeDao) {
    // Place to temp all datas from dao
    val allData: LiveData<List<Anime>> = dao.getAllData()

    /*TODO 2.8 - Since this is non-UI operation, you need a wrapper for this function or app will creash
        *@WorkerThread is an annotation to tell that this is non-UI operation
         *Suspend is a modifier to tell this function called from coroutine or another suspending function*/
    @WorkerThread
    suspend fun Insert(history:Anime)
    {
        dao.insert(history)
    }


}