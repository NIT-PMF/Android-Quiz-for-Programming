package com.example.kvizprogramiranje1.singleton



object questionSingletonData {
    private var questionEasyData: MutableList<QuestionSingleton?> = mutableListOf()
    private var questionNormalData: MutableList<QuestionSingleton?> = mutableListOf()
    private var questionHardData: MutableList<QuestionSingleton?> = mutableListOf()
    //Konstruktor za pitanja
    init {
        questionEasyData.add(
            QuestionSingleton(
                0,
                "hmmm?",
                null,
                "A",
                "B",
                "C",
                "D",
                "B",
                false,
                "MultipleChoice")
        )
        questionHardData.add(
            QuestionSingleton(
                0,
                "hmmm?2",
                "questionID1",
                "A",
                "B",
                "C",
                "D",
                "B",
                true,
                "MultipleChoice")

        )

        questionNormalData.add(
            QuestionSingleton(
                0,
                "hmmm?2",
                null,
                null,
                null,
                null,
                null,
                "B",
                true,
                "Text")

        )
    }

    //Vracanje liste s podacima
    fun getQuestionEasyData(): MutableList<QuestionSingleton?> {
        return questionEasyData
    }

    fun getQuestionNormalData(): MutableList<QuestionSingleton?> {
        return questionNormalData
    }

    fun getQuestionHardData(): MutableList<QuestionSingleton?> {
        return questionHardData
    }



    //Vracanje pitanja po ID-u
    fun getQuestionEasyById(QuestionId: Number): QuestionSingleton? {
        return questionEasyData.find { it?.id == QuestionId }
    }

    fun getQuestionNormalById(QuestionId: Number): QuestionSingleton? {
        return questionNormalData.find { it?.id == QuestionId }
    }

    fun getQuestionHardById(QuestionId: Number): QuestionSingleton? {
        return questionHardData.find { it?.id == QuestionId }
    }


    //Ukupan Broj Pitanja
    fun getQuestionDataSize(): Number {
        return questionEasyData.size + questionHardData.size + questionNormalData.size
    }

    //Dodaj Novo Pitanje
    fun addQuestionEasy(Question: QuestionSingleton) {
        questionEasyData.add(Question)
    }
    fun addQuestionNormal(Question: QuestionSingleton) {
        questionNormalData.add(Question)
    }
    fun addQuestionHard(Question: QuestionSingleton) {
        questionHardData.add(Question)
    }

}

data class QuestionSingleton(var id: Int, var questionText: String?, var questionImage: String?,
                             var answerA: String?, var answerB: String?, var answerC: String?, var answerD: String?,
                             var correctAnswer: String?, var isImageQuestion: Boolean, var category: String?)
