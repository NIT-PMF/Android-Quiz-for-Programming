package com.example.kvizprogramiranje1.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User() {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "name")
    var user_name:String = ""

    @ColumnInfo(name = "score")
    var user_score:Int = 0

    @ColumnInfo(name = "password")
    var user_password:String = ""

}