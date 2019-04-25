package com.cua.katsuhub.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.room_service.AnimeDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

//TODO 2.7 Create Repository for History
class HistoryRepository(private val dao:AnimeDao) {
    // Place to temp all datas from dao
    val allData: Flowable<List<Anime>> = dao.getAllData()

    /*TODO 2.8 - Since this is non-UI operation, you need a wrapper for this function or app will crash
        *@WorkerThread is an annotation to tell that this is non-UI operation
         *Suspend is a modifier to tell this function called from coroutine or another suspending function*/
    //@WorkerThread
    fun Insert(history:Anime): Completable {
        val anime:Anime = history; return dao.insert(anime)
    }


}