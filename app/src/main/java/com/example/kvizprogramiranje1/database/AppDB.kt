package com.example.kvizprogramiranje1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kvizprogramiranje1.dao.User_dao
import com.example.kvizprogramiranje1.entity.User

@Database(entities = [(User::class)], version = 3)
abstract  class AppDB: RoomDatabase(){


    abstract val userDatabaseDao: User_dao

    companion object {

        @Volatile
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB = synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "User_DB"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}