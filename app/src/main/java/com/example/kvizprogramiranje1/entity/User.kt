package com.example.kvizprogramiranje1.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "username")
    var username: String = "",

    @ColumnInfo(name = "userScore")
    var userScore: Int = 0,

    @ColumnInfo(name = "userPassword")
    var userPassword: String = ""
)