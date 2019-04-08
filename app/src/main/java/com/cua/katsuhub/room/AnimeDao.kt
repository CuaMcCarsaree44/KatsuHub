package com.cua.katsuhub.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cua.katsuhub.model.factory.AnimeHistory
import androidx.lifecycle.MutableLiveData

//TODO 2.2 - 做刀 interface！！！ 🔪
@Dao
interface AnimeDao {
    @Insert
    fun insert(weebs: AnimeHistory)

    //In case you accidently choosed a hentong
    @Query("DELETE FROM anime")
    fun deleteHistory()

    //Show all datas for recent anime
    @Query("SELECT * FROM anime")
    fun getRecent():MutableLiveData<List<AnimeDao>>
}