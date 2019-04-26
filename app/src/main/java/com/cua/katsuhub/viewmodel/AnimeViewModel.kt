package com.cua.katsuhub.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.anime.Data
import com.cua.katsuhub.model.animes.DataItem
import com.cua.katsuhub.services.AnimeRepository

class AnimeViewModel: ViewModel(){
    val animes:MutableLiveData<List<DataItem>> = MutableLiveData()
    val anime:MutableLiveData<Data> = MutableLiveData()
    val searchResult:MutableLiveData<List<DataItem>> = MutableLiveData()

    private var repos: AnimeRepository = AnimeRepository()


    fun getTrending(){
        repos.getTrending(
            {
                animes.postValue(it.data)
            },{
            it.printStackTrace()
        })
    }

    fun getSpecific(x:Int){
        repos.getSpecific(
            x, {
            anime.postValue(it.data)
        },{
            it.printStackTrace()
        })
    }

    fun getByTitle(x:String){
        repos.getTitle(x, {
            searchResult.postValue(it.data)
        }, {
            it.printStackTrace()
        })
    }
}