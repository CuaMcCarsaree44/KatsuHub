package com.cua.katsuhub.room_service

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.cua.katsuhub.model.room_package.Anime

//TODO 2.4 - Create a RoomDatabase by making it Abstract class and inherit RoomDatabase()
@Database(entities = [Anime::class], version = 1) //-> This thing will create Table
public abstract class AnimeRoomDatabase : RoomDatabase() {
    //TODO 2.5 - Define DAO that works with Database
    abstract fun animeDao():AnimeDao

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllTables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}