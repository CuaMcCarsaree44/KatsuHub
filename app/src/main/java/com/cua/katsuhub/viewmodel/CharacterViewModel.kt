package com.cua.katsuhub.viewmodel
import com.cua.katsuhub.model.Data
import com.cua.katsuhub.services.ApiServices
import com.cua.katsuhub.services.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel {
    fun search(x:String):Data
    {
        val conv: Converter = Converter()

        var api: ApiServices = conv.getInstance()
        val data: Call<Data> = api.getData(x)
        lateinit var get:Data

        data.enqueue(object: Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {

            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val status:Boolean = response.isSuccessful
                var feed = response?.body()
                if(status){
                    get = feed!!
                }else
                {
                }
            }
        })
        return get
    }
}