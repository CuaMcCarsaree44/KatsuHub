package com.cua.katsuhub.services

import com.cua.katsuhub.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/character?filter[name]")
    fun getData(@Query("name")character:String): Call<Data>
}