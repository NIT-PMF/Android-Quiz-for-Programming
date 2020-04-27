package com.example.kvizprogramiranje1

/* Sadrzi podatke o korisnicima */
object userSingletonData {
    private var userData: MutableList<UserSingleton?> = mutableListOf()

    //Konstruktor
    fun init() {
        userData.add(UserSingleton(0,"Tarik", 0))
        userData.add(UserSingleton(1,"Irhad", 1000))
    }

    //Vracanje liste s podacima
    fun getUserData(): MutableList<UserSingleton?> {
        return userData
    }

    //Vracanje korisnika po ID-u
    fun getUserById(UserId : Number) : UserSingleton? {
        return userData.find { it?.id ==  UserId }
    }

    //Ukupan Broj Korisnika
    fun getUserDataSize() : Number {
        return userData.size
    }

    //Dodaj Novog Korisnika
    fun addUser(User : UserSingleton) {
        userData.add(User)
    }
}

data class UserSingleton(val id:Number, val username: String, val score : Number)