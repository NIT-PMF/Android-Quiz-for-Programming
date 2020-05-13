package com.example.kvizprogramiranje1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kvizprogramiranje1.entity.User

@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query ("update quiz_users_table SET score = :score where UserId = :userId")
    fun updateUser(userId:Int, score:Int)

    @Query("DELETE FROM quiz_users_table WHERE UserId = :id")
    fun deleteUsers(id: Int)

    @Query("SELECT * from quiz_users_table WHERE UserId = :key")
    fun get(key: Int): User?

    @Query("DELETE FROM quiz_users_table")
    fun clear()

    @Query("SELECT * FROM quiz_users_table WHERE username = :username AND password = :password")
    fun getUserByPassword(username :String,password :String): User?

    @Query("SELECT * FROM quiz_users_table WHERE username = :username")
    fun getUserByName(username: String): User?

    @Query("SELECT * FROM quiz_users_table ORDER BY userScore DESC LIMIT 10")
    fun getUsers(): User?

    @Query("SELECT * FROM quiz_users_table ORDER BY userScore DESC")
    fun getAllUsers(): LiveData<List<User>>
}