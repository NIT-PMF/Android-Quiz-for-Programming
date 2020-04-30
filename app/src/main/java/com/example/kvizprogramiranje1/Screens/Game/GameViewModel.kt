package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData


// The current score
var score = 0

class GameViewModel : ViewModel() {
    // The current word

    var questionNumber = 3

    var questionsList = questionSingletonData.giveEasyQuiz(questionNumber)

    var question: Question? = null



    init {
        nextQuestion()
    }
    /** Methods for updating the UI **/
    fun onSkip() {
        nextQuestion()
    }
    fun onCorrect() {
        score++
        nextQuestion()
    }

    /**
     * Moves to the next word in the list.
     */


    private fun nextQuestion() {
        //Select and remove a word from the list
        if (!questionsList.isEmpty()) {
            question = questionsList.removeAt(0)
        }
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "GameViewModelDestroyed")
    }
}
