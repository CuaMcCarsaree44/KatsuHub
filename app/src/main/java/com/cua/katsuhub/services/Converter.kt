package com.cua.katsuhub.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Converter {
    private val apiBody = "https://kitsu.io/api/edge/"

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .followRedirects(false)
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val builderNew = chain.request().newBuilder()
                builderNew.addHeader("Accept", "application/vnd.api+json")
                builderNew.addHeader("Content-Type", "application/vnd.api+json")
                val requestNew = builderNew.build()
                chain.proceed(requestNew)
            }
            .build()
    }

    private fun setInit(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(apiBody)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    fun getInstance(): ApiServices
    {
        return setInit().create(ApiServices::class.java)
    }
}