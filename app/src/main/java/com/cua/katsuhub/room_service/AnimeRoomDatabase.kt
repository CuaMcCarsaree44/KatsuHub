package com.cua.katsuhub.room_service

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.cua.katsuhub.model.room_package.Anime

//TODO 2.4 - Create a RoomDatabase by making it Abstract class and inherit RoomDatabase()
@Database(entities = [Anime::class], version = 1) //-> This thing will create Table
abstract class AnimeRoomDatabase : RoomDatabase() {
    //TODO 2.5 - Define DAO that works with Database
    abstract fun animeDao():AnimeDao

    //TODO 2.6 - Create AnimeRoomDatabase Singleton to prevent RoomDatabase creating more than 1 instance=
    companion object{
        @Volatile
        private var instance:AnimeRoomDatabase? = null

        fun getDatabase(context: Context):AnimeRoomDatabase{
            if(instance != null)
            {
                return instance as AnimeRoomDatabase
            }

            synchronized(this){
                //This is where you put Database Name.
                val new_instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimeRoomDatabase::class.java,
                    "Katsu_Database").build()

                instance = new_instance
                return instance as AnimeRoomDatabase
            }
        }
    }



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