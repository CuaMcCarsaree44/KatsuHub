package com.cua.katsuhub.services

import com.cua.katsuhub.model.anime.AnimeRoot
import com.cua.katsuhub.model.animes.Response
import com.cua.katsuhub.model.response.CharacterResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//TODO RxJava 101 - 1.2 Change Call into Observable
interface ApiServices {
    @GET("characters")
    fun getData(@Query("filter[name]") character: String): Observable<CharacterResponse>

    @GET("trending/anime")
    fun getTrending(): Observable<Response>

    @GET("anime/{id}")
    fun getSpecific(@Path("id") id: Int):Observable<AnimeRoot>

    @GET("/library-entries")
    fun getTitle(@Query("filter[title]") title: String): Call<Response>
}