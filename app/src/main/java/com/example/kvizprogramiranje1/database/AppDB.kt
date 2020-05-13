package com.example.kvizprogramiranje1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kvizprogramiranje1.dao.UserDatabaseDao
import com.example.kvizprogramiranje1.entity.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 20, exportSchema = false)
abstract  class AppDB: RoomDatabase(){


    abstract val userDatabaseDao: UserDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): AppDB {
            synchronized(this) {
                var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "quiz_users_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                    }
                    return instance
                }
            }
        }
}