package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData
import com.example.kvizprogramiranje1.singleton.questionSingletonData.giveEasyQuiz


// The current score

var score = 0

class GameViewModel(questionNumber: Int, mode: Int) : ViewModel() {


    var question: Question? = null

    var questionsList:MutableList<Question?>

    var points : Int
    var penaltyPoints: Int

    init {


        if(mode == 1){
            questionsList = questionSingletonData.giveEasyQuiz(questionNumber)
            points = 10
            penaltyPoints = 5
        }else if(mode == 2){
            questionsList = questionSingletonData.giveMediumQuiz(questionNumber)
            points = 12
            penaltyPoints = 4
        }else{
            questionsList = questionSingletonData.giveHardQuiz(questionNumber)
            points = 20
            penaltyPoints = 10
        }
        score = 0
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
                score += points
            }else{
                score -= penaltyPoints
            }
        }else{
            for(answer in answers){
                if(question!!.correctAnswers!!.contains(answer)){
                    score += points
                }else{
                    score -= penaltyPoints
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
