package com.example.kvizprogramiranje1.logic

import com.example.kvizprogramiranje1.singleton.UserSingleton
import com.example.kvizprogramiranje1.singleton.userSingletonData

fun checkUsername(username: String): Boolean {
    return if (username.length > 1) {
        userSingletonData.addUser(
            UserSingleton(
                userSingletonData.getUserDataSize().toInt(),
                username,
                0
            )
        )
         true
    } else
         false
}