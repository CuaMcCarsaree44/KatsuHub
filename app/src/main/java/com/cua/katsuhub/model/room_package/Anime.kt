package com.cua.katsuhub.model.room_package

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

//TODO 2.1 - Add Entity as Table
@Entity(tableName = "Anime")
data class Anime (
    @PrimaryKey @ColumnInfo(name = "id") val url:String = "",
    @ColumnInfo(name = "image") val image:String = "",
    @ColumnInfo(name = "title") val title:String = "",
    @ColumnInfo(name = "created_at") val created_at: Timestamp = Timestamp(System.currentTimeMillis())
)