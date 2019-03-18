package com.cua.katsuhub.services

import com.cua.katsuhub.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("characters")
    fun getData(@Query("filter[name]")character:String): Call<Data>
}