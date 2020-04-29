package com.example.kvizprogramiranje1.logic

import com.example.kvizprogramiranje1.singleton.User
import com.example.kvizprogramiranje1.singleton.userSingletonData


//Provjerava da li postoji korisnik vec
fun checkUsername(username: String): Boolean {
    return if (username.length > 1) {
        userSingletonData.addUser(
            User(
                userSingletonData.getUserDataSize().toInt(),
                username,
                0
            )
        )
         true
    } else
         false
}