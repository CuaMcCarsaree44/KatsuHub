package com.cua.katsuhub.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.anime.AnimeRoot
import com.cua.katsuhub.model.anime.Data
import com.cua.katsuhub.model.animes.DataItem
import com.cua.katsuhub.model.animes.Response
import com.cua.katsuhub.services.ApiConnection
import retrofit2.Call
import retrofit2.Callback

class AnimeViewModel: ViewModel(){
    val animes = MutableLiveData<List<DataItem>>()
    val anime = MutableLiveData<Data>()

    private val api = ApiConnection().getInstance()

    fun getTrending(){
        api.getTrending().enqueue(object: Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("REQUEST", "Failed to fetch data")
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful)
                {
                    Log.d("REQUEST", "Look at all of this. getTrending() is return 200")
                    response.body()?.let{
                        animes.postValue(it.data)
                    }
                }else
                {
                    Log.d("REQUEST", "Hmmmm Not Found. Is your anime thing down or something?")
                }
            }

        })
    }

    fun getSpecific(x:Int)
    {
        api.getSpecific(x).enqueue(object:Callback<AnimeRoot>{
            override fun onFailure(call: Call<AnimeRoot>, t: Throwable) {
                Log.d("REQUEST", "Failed to fetch data")
            }

            override fun onResponse(call: Call<AnimeRoot>, response: retrofit2.Response<AnimeRoot>) {
                if(response.isSuccessful)
                {
                    response.body()?.let{
                        anime.postValue(it.data)
                    }
                }else
                {
                    Log.d("REQUEST", "Failed to fetch data")
                }
            }

        })
    }

}