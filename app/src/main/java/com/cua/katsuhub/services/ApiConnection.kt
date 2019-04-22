package com.cua.katsuhub.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//TODO RxJava 101 - 1.3 Change everything inside here.
class ApiConnection {
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

    fun getInstance(): ApiServices{
        val retrofitService = Retrofit.Builder()
            .baseUrl(apiBody)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
        return retrofitService.create(ApiServices::class.java)
    }


    companion object {
        private const val apiBody = "https://kitsu.io/api/edge/"
    }
}