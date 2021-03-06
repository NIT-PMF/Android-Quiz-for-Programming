package com.example.kvizprogramiranje1.singleton

/** Sadrzi podatke o korisnicima **/
object userSingletonData {
    private var userData: MutableList<User?> = mutableListOf()

    //Konstruktor za korisnika
    init {
        userData.add(
            User(
                0,
                "Tarik",
                52)
        )
        userData.add(
            User(
                1,
                "Irhad",
                1000
            )
        )
    }


    //Vracanje liste s podacima
    fun getUserData(): MutableList<User?> {
        return userData
    }

    fun findUser(username: String): User? {
        return userData.find {
            user -> user?.username.equals(username)
        }
    }

    //Vracanje korisnika po ID-u
    fun getUserById(UserId: Number): User? {
        return userData.find { it?.id == UserId }
    }

    fun getUserByName(username: String): User? {
        return userData.find {it?.username == username}
    }

    //Ukupan Broj Korisnika
    fun getUserDataSize(): Number {
        return userData.size
    }

    //Dodaj Novog Korisnika
    fun addUser(User: User) {
        userData.add(User)
    }

    fun showHighscore(): List<User?> {
        return userData.sortedByDescending { it?.score }.take(10)
    }
}

data class User(val id: Number, val username: String, val score: Int)