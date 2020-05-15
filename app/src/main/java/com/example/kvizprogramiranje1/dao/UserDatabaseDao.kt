package com.example.kvizprogramiranje1.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kvizprogramiranje1.entity.User

//Data Access object, cuvamo upite koje saljemo na bazu
@Dao
interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query ("update quiz_users_table SET userScore = :score where username = :username")
    suspend fun updateUser(username: String, score:Int)

    @Query("DELETE FROM quiz_users_table WHERE UserId = :id")
    suspend fun deleteUsers(id: Int)

    @Query("SELECT * from quiz_users_table WHERE UserId = :key")
    fun get(key: Int): User?

    @Query("DELETE FROM quiz_users_table")
    suspend fun clear()

    @Query("SELECT * FROM quiz_users_table WHERE username = :username AND userPassword = :password")
    fun getUserByPassword(username :String,password :String): User?

    @Query("SELECT * FROM quiz_users_table WHERE username = :username")
    fun getUserByName(username: String): User?

    @Query("SELECT * FROM quiz_users_table ORDER BY userScore DESC LIMIT 10")
    fun getUsers(): User?

    @Query("SELECT * FROM quiz_users_table ORDER BY userScore DESC")
    fun getAllUsers(): List<User>
}