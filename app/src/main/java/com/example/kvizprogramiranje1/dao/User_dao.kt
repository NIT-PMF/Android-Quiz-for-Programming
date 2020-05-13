package com.example.kvizprogramiranje1.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kvizprogramiranje1.entity.User

@Dao
interface User_dao {

    @Insert
    fun saveUser(user: User)

    @Query("select * from User")
    fun getUsers(): LiveData<List<User>>

    @Query ("update User SET score = :score where id = :userId")
    fun updateUser(userId:Int, score:Int)

    @Query("delete from User")
    fun deleteUsers()
}