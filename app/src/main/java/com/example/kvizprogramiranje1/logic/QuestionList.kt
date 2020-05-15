package com.example.kvizprogramiranje1.logic

import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData

//Singleton sa svim pitanjima i njihovim prevodima
fun allQuestions(): Triple<MutableList<Question>, MutableList<Question>, MutableList<Question>> {
    val hardQuestionList: MutableList<Question> = mutableListOf()
    val mediumQuestionList: MutableList<Question> = mutableListOf()
    val easyQuestionList: MutableList<Question> = mutableListOf()

    hardQuestionList.addAll(
        mutableListOf(
            Question(
                21,
                "hard1",
                "hard2.jpg",
                mutableListOf("hard1_ans1", "hard1_ans2", "hard1_ans3", "hard1_ans4"),
                mutableListOf("hard1_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                22,
                "hard2",
                null,
                mutableListOf("hard2_ans1", "hard2_ans2", "hard2_ans3", "hard2_ans4"),
                mutableListOf("hard2_ans2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                23,
                "hard4",
                null,
                mutableListOf("hard3_ans1", "hard3_ans2", "hard3_ans3", "hard3_ans4"),
        mutableListOf("hard3_ans4"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                24,
                "hard4",
                null,
                mutableListOf("hard4_ans1", "hard4_ans2", "hard4_ans3", "hard4_ans4"),
                mutableListOf("hard4_ans4"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                25,
                "hard5",
                "hard3.jpg",
                mutableListOf("hard5_ans1", "hard5_ans2", "hard5_ans3", "hard5_ans4"),
                mutableListOf("hard5_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                26,
                "hard6",
                "hard4.jpg",
                mutableListOf("hard6_ans1", "hard6_ans2", "hard6_ans3", "hard6_ans4"),
                mutableListOf("hard6_ans1"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                27,
                "hard7",
                null,
                mutableListOf("hard7_ans1", "hard7_ans2", "hard7_ans3"),
                mutableListOf("hard7_ans3"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                28,
                "hard8",
                null,
                null,
                mutableListOf("len(foo)"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                29,
                "hard9",
                null,
                mutableListOf("hard9_ans1", "hard9_ans2", "hard9_ans3", "hard9_ans4"),
                mutableListOf("hard9_ans1", "hard9_ans2"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                30,
                "hard10",
                null,
                mutableListOf("hard10_ans1", "hard10_ans2", "hard10_ans3", "hard10_ans4"),
                mutableListOf("hard10_ans3", "hard10_ans4"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                31,
                "hard11",
                null,
                null,
                mutableListOf("lower()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),

            Question(
                34,
                "hard12",
                null,
                mutableListOf("hard12_ans1", "hard12_ans2", "hard12_ans3", "hard12_ans4"),
                mutableListOf("hard12_ans2", "hard12_ans3"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                36,
                "hard13",
                null,
                mutableListOf("hard13_ans1", "hard13_ans2", "hard13_ans3", "hard13_ans4"),
                mutableListOf("hard13_ans1", "hard13_ans2"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                35,
                "hard14",
                "hard5.jpg",
                mutableListOf("hard14_ans1", "hard14_ans2", "hard14_ans3"),
                mutableListOf("hard14_ans1", "hard14_ans3", "hard14_ans3"),
                true,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                37,
                "hard15",
                null,
                null,
                mutableListOf("list(S)"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                32,
                "hard16",
                null,
                mutableListOf("hard16_ans1", "hard16_ans2", "hard16_ans3"),
                mutableListOf("hard16_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                32,
                "hard16",
                null,
                mutableListOf("hard16_ans1", "hard16_ans2", "hard16_ans3"),
                mutableListOf("hard16_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )

        )
    )

    mediumQuestionList.addAll(
        mutableListOf(
            Question(
                11,
                "medium1",
                null,
                mutableListOf("medium1_ans1", "medium1_ans2", "medium1_ans3"),
                mutableListOf("medium1_ans3"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                12,
                "medium2",
                "medium1.jpg",
                mutableListOf("medium2_ans1", "medium2_ans2", "medium2_ans3"),
                mutableListOf("medium2_ans1"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                13,
                "medium3",
                null,
                mutableListOf("medium3_ans1", "medium3_ans2","medium3_ans3","medium3_ans4"),
                mutableListOf("medium3_ans1", "medium3_ans4"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                14,
                "medium4",
                null,
                null,
                mutableListOf("yes"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                15,
                "medium5",
                "medium3.jpg",
                mutableListOf("medium5_ans1", "medium5_ans2", "medium5_ans3", "medium5_ans4"),
                mutableListOf("medium5_ans1"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                17,
                "medium7",
                null,
                null,
                mutableListOf("string"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),

            Question(
                19,
                "medium8",
                null,
                null,
                mutableListOf("int(\"A\",16)"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                20,
                "medium9",
                "medium4.jpg",
                mutableListOf("medium9_ans1", "medium9_ans2", "medium9_ans3", "medium9_ans4"),
                mutableListOf("medium9_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                21,
                "medium10",
                null,
                null,
                mutableListOf("shuffle(LST)"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                22,
                "medium11",
                null,
                mutableListOf("medium11_ans1", "medium11_ans2", "medium11_ans3", "medium11_ans4"),
                mutableListOf("medium11_ans2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                23,
                "medium12",
                null,
                null,
                mutableListOf("upper()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                24,
                "medium13",
                null,
                mutableListOf("medium13_ans1", "medium13_ans2", "medium13_ans3",  "medium13_ans4"),
                mutableListOf("medium13_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                25,
                "medium14",
                "medium5.jpg",
                mutableListOf("medium14_ans1", "medium14_ans2", "medium14_ans3",  "medium14_ans4"),
                mutableListOf("medium14_ans4"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                26,
                "medium15",
                null,
                mutableListOf("medium15_ans1", "medium15_ans2", "medium15_ans3",  "medium15_ans4"),
                mutableListOf("medium15_ans3"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                27,
                "medium16",
                "medium5.jpg",
                mutableListOf("medium16_ans1", "medium16_ans2", "medium16_ans3",  "medium16_ans4"),
                mutableListOf("medium16_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                27,
                "medium16",
                "medium5.jpg",
                mutableListOf("medium16_ans1", "medium16_ans2", "medium16_ans3",  "medium16_ans4"),
                mutableListOf("medium16_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
        )
    )
    easyQuestionList.addAll(
        mutableListOf(

            Question(
                1,
                "easy1",
                null,
                mutableListOf("easy1_ans1", "easy1_ans2"),
                mutableListOf("easy1_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                2,
                "easy2",
                null,
                mutableListOf("easy2_ans1", "easy2_ans2", "easy2_ans3"),
                mutableListOf("easy2_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                3,
                "easy3",
                null,
                mutableListOf("easy3_ans1","easy3_ans2", "easy3_ans3"),
                mutableListOf("easy3_ans2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                4,
                "easy4",
                "easy1.jpg",
                mutableListOf("easy4_ans1", "easy4_ans2", "easy4_ans3", "easy4_ans4"),
                mutableListOf("easy4_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                5,
                "easy5",
                null,
                mutableListOf("easy5_ans1", "easy5_ans2", "easy5_ans3", "easy5_ans4"),
                mutableListOf("easy5_ans4"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                6,
                "easy6",
                null,
                mutableListOf("easy6_ans1", "easy6_ans2", "easy6_ans3", "easy6_ans4"),
                mutableListOf("easy6_ans2"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                7,
                "easy7",
                null,
                mutableListOf("easy7_ans1", "easy7_ans2", "easy7_ans3", "easy7_ans4"),
                mutableListOf("easy7_ans4"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                8,
                "easy8",
                null,
                null,
                mutableListOf("append", "insert", "remove", "pop", "clear", "count", "sort", "copy", "reverse"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                9,
                "easy9",
                null,
                mutableListOf("easy9_ans1", "easy9_ans2", "easy9_ans3", "easy9_ans4"),
                mutableListOf("easy9_ans1", "easy9_ans2", "easy9_ans3"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                10,
                "easy10",
                null,
                mutableListOf("easy10_ans1", "easy10_ans2", "easy10_ans3", "easy10_ans4"),
                mutableListOf("easy10_ans1", "easy10_ans2", "easy10_ans4"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                11,
                "easy11",
                null,
                null,
                mutableListOf("+"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                12,
                "easy12",
                null,
                mutableListOf("easy12_ans1", "easy12_ans2", "easy12_ans3", "easy12_ans4"),
                mutableListOf("easy12_ans1"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                13,
                "easy13",
                "easy3.jpg",
                mutableListOf("easy13_ans1", "easy13_ans2", "easy13_ans3", "easy13_ans4"),
                mutableListOf("easy13_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                14,
                "easy14",
                "easy4.jpg",
                mutableListOf("easy14_ans1", "easy14_ans2", "easy14_ans3", "easy14_ans4"),
                mutableListOf("easy14_ans2"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                15,
                "easy15",
                null,
                mutableListOf("easy15_ans1", "easy15_ans2", "easy15_ans3"),
                mutableListOf("easy15_ans1", "easy15_ans2", "easy15_ans3"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                17,
                "easy17",
                "easy5.jpg",
                mutableListOf("easy17_ans1", "easy17_ans2", "easy17_ans3", "easy17_ans4"),
                mutableListOf("easy17_ans1"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )

        )
    )

    return Triple(easyQuestionList, mediumQuestionList, hardQuestionList)
}