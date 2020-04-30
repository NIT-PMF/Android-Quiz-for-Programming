package com.example.kvizprogramiranje1.singleton

import com.example.kvizprogramiranje1.logic.allQuestions
import com.example.kvizprogramiranje1.logic.getHalfQuestions
import com.example.kvizprogramiranje1.logic.getQuarterQuestions

object questionSingletonData {
    //Tezina
    val QUESTION_SINGLE_CHOICE: Number = 1
    val QUESTION_MULTIPLE_CHOICE: Number = 2
    val QUESTION_TEXT: Number = 3


    //Raspodjela pitanja po tezini
    private var questionsEasyData: MutableList<Question?> = mutableListOf()
    private var questionsNormalData: MutableList<Question?> = mutableListOf()
    private var questionsHardData: MutableList<Question?> = mutableListOf()

    //Konstruktor za pitanja
    init {
        val (questionsEasyData, questionNormalData, questionHardData) = allQuestions()
    }

    //Vracanje liste s podacima
    fun getQuestionEasyData(): MutableList<Question?> {
        return questionsEasyData
    }

    fun getQuestionNormalData(): MutableList<Question?> {
        return questionsNormalData
    }

    fun getQuestionHardData(): MutableList<Question?> {
        return questionsHardData
    }



    //Vracanje pitanja po ID-u
    fun getQuestionEasyById(QuestionId: Number): Question? {
        return questionsEasyData.find { it?.id == QuestionId }
    }

    fun getQuestionNormalById(QuestionId: Number): Question? {
        return questionsNormalData.find { it?.id == QuestionId }
    }

    fun getQuestionHardById(QuestionId: Number): Question? {
        return questionsHardData.find { it?.id == QuestionId }
    }

    //Ukupan Broj Pitanja
    fun getQuestionDataSize(): Number {
        return questionsEasyData.size + questionsHardData.size + questionsNormalData.size
    }

    //Dodaj Novo Pitanje
    fun addQuestionEasy(Question: Question) {
        questionsEasyData.add(Question)
    }
    fun addQuestionNormal(Question: Question) {
        questionsNormalData.add(Question)
    }
    fun addQuestionHard(Question: Question) {
        questionsHardData.add(Question)
    }

    //Vracanje izmijesane liste pitanja zavisno od tezine (Pocetak Kviza)
    fun giveEasyQuiz(questionsNo: Int) {
        val questionList = getQuarterQuestions(questionsHardData, questionsNo) +
                getQuarterQuestions(questionsNormalData, questionsNo) +
                getHalfQuestions(questionsEasyData, questionsNo)

        return questionList.toMutableList().shuffle()

    }
    fun giveMediumQuiz(questionsNo: Int) {
        val questionList = getQuarterQuestions(questionsHardData, questionsNo) +
                getHalfQuestions(questionsNormalData, questionsNo) +
                getQuarterQuestions(questionsEasyData, questionsNo)

        return questionList.toMutableList().shuffle()

    }
    fun giveHardQuiz(questionsNo: Int) {
        val questionList = getHalfQuestions(questionsHardData, questionsNo) +
                getQuarterQuestions(questionsNormalData, questionsNo) +
                getQuarterQuestions(questionsEasyData, questionsNo)

        return questionList.toMutableList().shuffle()
    }

}

data class Question(val id: Number, val questionText: String?, val questionImage: String?,
                             val possibleAnswers: MutableList<String>?, val correctAnswers: MutableList<String>?,
                             val isImageQuestion: Boolean, val questionCategory: Number)
