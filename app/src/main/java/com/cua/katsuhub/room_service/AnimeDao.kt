package com.cua.katsuhub.room_service

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cua.katsuhub.model.room_package.Anime
import io.reactivex.Completable
import io.reactivex.Flowable
import androidx.room.OnConflictStrategy
//TODO 2.2 - Create Dao
@Dao
interface AnimeDao {
    /*Incase you want append data upon inserting same IDs: @Insert(onConflict = onConflictStrategy.REPLACE)
    *By default, @Insert will be like -> @Insert(onConflict = onConflictStrategy.ABORT)
    *But, since we got out primary key depends on Unix Timestamp or current second since 01-01-1970 07:00:00.000 UTC
    *So... No Conflict will be happen :) Because Time change upon the time.
    */
    @Insert (onConflict = OnConflictStrategy.ABORT)
    fun insert(anime: Anime): Completable

    //TODO 2.3 - Edit SELECT * into something that could be put in MutableLiveData<List<Anime>>()
    @Query("SELECT * FROM Anime ORDER BY created_at DESC")
    fun getAllData(): Flowable<List<Anime>>

    @Query("DELETE FROM Anime")
    fun deleteAll()
}