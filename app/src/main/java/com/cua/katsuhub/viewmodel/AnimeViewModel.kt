package com.cua.katsuhub.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cua.katsuhub.model.animes.Response
import com.cua.katsuhub.services.ApiConnection
import retrofit2.Call
import retrofit2.Callback

class AnimeViewModel {
    val animes = MutableLiveData<List<Response>>()

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
                }else
                {
                    Log.d("REQUEST", "Hmmmm Not Found. Is your anime thing down or something?")
                }
            }

        })
    }
}