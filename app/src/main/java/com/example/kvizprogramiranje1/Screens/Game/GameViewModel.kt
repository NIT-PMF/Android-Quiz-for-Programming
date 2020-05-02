package com.example.kvizprogramiranje1.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData


// The current score

var score = 0

class GameViewModel(questionNumber: Int, mode: Int) : ViewModel() {

    var numOfQuestionRight = 0

    var popUpClicked = false

    var question: Question? = null

    var questionsList: MutableList<Question?>

    var points: Int
    var penaltyPoints: Int


    init {


        if (mode == 1) {
            questionsList = questionSingletonData.giveEasyQuiz(questionNumber)
            points = 10
            penaltyPoints = 5
        } else if (mode == 2) {
            questionsList = questionSingletonData.giveMediumQuiz(questionNumber)
            points = 12
            penaltyPoints = 4
        } else {
            questionsList = questionSingletonData.giveHardQuiz(questionNumber)
            points = 20
            penaltyPoints = 10
        }
        score = 0
        popUpClicked = false
        numOfQuestionRight = 0
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

    fun onCheckAnswers(answers: ArrayList<String>) {
        if (question?.possibleAnswers == null) {
            var answersType = answers[0].toLowerCase().split(",")
            var brojac = 0
            for (answer in answersType) {
                brojac++
                Log.i(answer, "lol")
                if (question!!.correctAnswers!!.contains(answer)) {
                    Log.i(answer, "lol")
                    score += points
                    if(brojac == answersType.size){
                        numOfQuestionRight++
                    }
                } else {
                    score -= penaltyPoints
                }
            }
        } else {
            var brojac = 0
            for (correct in question!!.correctAnswers!!) {
                Log.i(correct, "gmm")
                brojac++
                for(answer in answers){
                    Log.i(answer, "mmm")
                }
                if (answers.contains(correct)) {
                        Log.i(correct, "hmm")
                    score += points
                    if(brojac == answers.size){
                        numOfQuestionRight++
                    }
                } else {
                    score -= penaltyPoints
                }
            }
        }

        nextQuestion()

    }

    internal fun questionRemain(): Int {
        return questionsList.size
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
