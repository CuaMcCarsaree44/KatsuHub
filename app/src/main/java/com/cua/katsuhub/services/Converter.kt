package com.cua.katsuhub.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Converter {
    val API_BODY:String = "https://kitsu.io/api/edge/"

    private fun setInit(): Retrofit
    {
        return Retrofit.Builder().baseUrl(API_BODY).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getInstance(): ApiServices
    {
        return setInit().create(ApiServices::class.java)
    }
}