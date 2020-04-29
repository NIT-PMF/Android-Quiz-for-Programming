package com.example.kvizprogramiranje1.logic

import com.example.kvizprogramiranje1.singleton.Question
import kotlin.math.round

//Izmijesa citavu listu i vraca
fun randomizeQuestion(questions: MutableList<Question?>) {
    return questions.shuffle()
}

//Vraca nasumicno pitanje unutar proslijedjene liste
fun getRandomizedQuestion(questions: MutableList<Question>): Question {
    return questions.random()
}
//Procenti
fun getQuarterQuestions(questions: MutableList<Question?>, questionNo: Int): List<Question?> {
    return questions.take((questionNo * 0.25).toInt())
}

fun getHalfQuestions(questions: MutableList<Question?>, questionNo: Int): List<Question?> {
    return questions.take((questionNo * 0.50).toInt())
}