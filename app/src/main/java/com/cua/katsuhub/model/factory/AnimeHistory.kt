package com.cua.katsuhub.model.factory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//TODO 2.1 - Create Entity Class
@Entity(tableName = "anime") //只个事用 class
data class AnimeHistory (
    @ColumnInfo(name = "image") //Column Name
    val imageUri:String = "",

    @PrimaryKey //Set Primary Key
    @ColumnInfo(name = "id") //Set Column Name
    val id:Int = 0
)