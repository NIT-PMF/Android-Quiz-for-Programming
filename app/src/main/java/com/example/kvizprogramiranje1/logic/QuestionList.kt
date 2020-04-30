package com.example.kvizprogramiranje1.logic

import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData

fun allQuestions(): Triple<MutableList<Question>, MutableList<Question>, MutableList<Question>> {
    val hardQuestionList: MutableList<Question> = mutableListOf()
    val mediumQuestionList: MutableList<Question> = mutableListOf()
    val easyQuestionList: MutableList<Question> = mutableListOf()

    hardQuestionList.addAll(
        mutableListOf(
            Question(
            1,
            "hmmm?",
            null,
            mutableListOf("odg1", "odg2"),
            mutableListOf("odg1"),
            false,
            questionSingletonData.QUESTION_SINGLE_CHOICE
        ),
            Question(
                2,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                3,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                4,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                5,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
    )
    )
    mediumQuestionList.addAll(
        mutableListOf(
            Question(
                1,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2"),
                mutableListOf("odg1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                2,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                3,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                4,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                5,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
        )
    )
    easyQuestionList.addAll(
        mutableListOf(
            Question(
                1,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2"),
                mutableListOf("odg1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                2,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                3,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                4,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                5,
                "hmmm?",
                null,
                mutableListOf("odg1", "odg2", "odg3"),
                mutableListOf("odg1", "odg2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
        )
    )

    return Triple(easyQuestionList, mediumQuestionList, hardQuestionList)
}