package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData
import com.example.kvizprogramiranje1.singleton.questionSingletonData.giveEasyQuiz


// The current score
var score = 0

class GameViewModel : ViewModel() {

    private var questionNumber = 4

    var question: Question? = null

    var questionsList:MutableList<Question?>

    init {
        questionsList = questionSingletonData.giveEasyQuiz(questionNumber)
        nextQuestion()
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        nextQuestion()
    }

    fun onCorrect() {
        score++
        score = 0
    }

    fun onCheckAnswers(answers : ArrayList<String>) {
        if(question?.possibleAnswers == null) {
            if(question!!.correctAnswers!!.contains(answers[0])) {
                score += 10
            }else{
                score -= 5
            }
        }else{
            for(answer in answers){
                if(question!!.correctAnswers!!.contains(answer)){
                    score += 10
                }else{
                    score -=10
                }
            }
        }

        nextQuestion()

    }


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
