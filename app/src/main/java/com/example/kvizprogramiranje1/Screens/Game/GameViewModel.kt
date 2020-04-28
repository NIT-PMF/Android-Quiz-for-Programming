package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    init {
        Log.d("GameViewModel", "GameViewModelCreated")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "GameViewModelDestroyed")
    }
}
