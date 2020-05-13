package com.example.kvizprogramiranje1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kvizprogramiranje1.dao.UserDatabaseDao
import com.example.kvizprogramiranje1.entity.User
import kotlinx.coroutines.*

class MainActivityViewModel(
    val database: UserDatabaseDao,
    application: Application
): AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var users = MutableLiveData<User?>()

    init {
        getUsers()
    }

    private fun getUsers() {
        uiScope.launch {
            users.value = getUsersFromDatabase()
        }
    }

    private suspend fun getUsersFromDatabase(): User? {
        return  withContext(Dispatchers.IO) {
            var user = database.getUsers()
            user
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}