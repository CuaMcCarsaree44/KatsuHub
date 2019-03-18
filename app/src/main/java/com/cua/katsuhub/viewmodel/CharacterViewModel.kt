package com.cua.katsuhub.viewmodel

import com.cua.katsuhub.model.Data
import com.cua.katsuhub.services.ApiServices
import com.cua.katsuhub.services.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.cua.katsuhub.services.DUMMY

class CharacterViewModel {
    fun search(x:String):Data
    {
        val conv:Converter = Converter()
        var feed:Data = null

        var api: ApiServices = conv.getInstance()
        val data: Call<Data> = api.getData(x)

        data.enqueue(object: Callback<Data>{
            override fun onFailure(call: Call<Data>, t: Throwable) {
                DUMMY = "It's Failure"
            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val status:Boolean = response.isSuccessful
                feed = response.body()!!
                if(status){
                    DUMMY = "It found! It Found!!!"
                }else
                {
                    DUMMY = "It goes to Response, but failed"
                }
            }
        })
        return feed
    }
}