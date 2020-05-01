package com.example.kvizprogramiranje1.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameViewModelFactory(private val numberOfQuestions: Int, private val mode: Int): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(numberOfQuestions, mode) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }}