package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    init {

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "GameViewModelDestroyed")
    }
}
