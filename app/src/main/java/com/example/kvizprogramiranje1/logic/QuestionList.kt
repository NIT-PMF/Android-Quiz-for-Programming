package com.example.kvizprogramiranje1.logic

import android.graphics.Typeface
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.singleton.Question
import com.example.kvizprogramiranje1.singleton.questionSingletonData

fun allQuestions(): Triple<MutableList<Question>, MutableList<Question>, MutableList<Question>> {
    val hardQuestionList: MutableList<Question> = mutableListOf()
    val mediumQuestionList: MutableList<Question> = mutableListOf()
    val easyQuestionList: MutableList<Question> = mutableListOf()

    hardQuestionList.addAll(
        mutableListOf(
            Question(
                21,
                "What is the output of the following code?",
                "hard2.jpg",
                mutableListOf("i is 5 isPrime is True", "i is 5 isPrime is False", "i is 6 isPrime is True", "i is 6 isPrime is False"),
                mutableListOf("i is 5 isPrime is False"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                22,
                "Suppose we have two sets A & B, then A<B is?",
                null,
                mutableListOf("True if len(A) is less than len(B).", "True if A is a proper subset of B.", "True if the elements in A when compared are less than the elements in B.", "True if A is a proper superset of B."),
                mutableListOf("True if A is a proper subset of B."),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                23,
                "Which options are correct to create an empty set in Python?",
                null,
                mutableListOf("{}", "[]", "()", "set()"),
                mutableListOf("set()"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                24,
                "In python3 what does // operator do?",
                null,
                mutableListOf("Float division", "returns remainder", "same as a**b", "Integer division"),
                mutableListOf("Integer division"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                25,
                "What are the base cases in the following recursive function?",
                "hard3.jpg",
                mutableListOf("n>0", "n<=0", "no base cases", "n<0"),
                mutableListOf("n<=0"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                26,
                "What is the output of the following code for print(f2(2, 0))?",
                "hard4.jpg",
                mutableListOf("0", "1", "2", "3"),
                mutableListOf("0"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                27,
                "What relationship is appropriate for Student and Person?",
                null,
                mutableListOf("association", "composition", "inheritance"),
                mutableListOf("inheritance"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                28,
                "What method is used to return the length of array foo?",
                null,
                null,
                mutableListOf("len(foo)"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                29,
                "What methods are used to remove an element from an array?",
                null,
                mutableListOf("remove()", "pop()", "delete()", "clear()"),
                mutableListOf("remove()", "pop()"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                30,
                "What methods are used to join two existing sets in Python?",
                null,
                mutableListOf("join()", "add()", "union()", "update()"),
                mutableListOf("union()", "update()"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                31,
                "To convert a string to lowercase, what Python function can be used?",
                null,
                null,
                mutableListOf("lower()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                32,
                "What are Python packages?",
                null,
                mutableListOf("namespaces containing modules", "namespaces containing single module", "helper function"),
                mutableListOf("namespaces containing modules"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                33,
                "To convert a string to lowercase, what Python function can be used?",
                null,
                null,
                mutableListOf("lower()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                34,
                "In what ways can we add values to a python array?",
                null,
                mutableListOf("add()", "extend()", "insert(i,x)", "join()"),
                mutableListOf("extend()", "insert(i,x)"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                35,
                "What is the output of this code?",
                "hard5.jpg",
                mutableListOf("array(‘d’, [1.1, 2.1, 3.1, 3.4])", "array(‘d’, [1.1, 2.1, 3.1, 3.4, 4.5, 6.3, 6.8])", "array(‘d’, [1.1, 2.1, 3.8, 3.1, 3.4, 4.5, 6.3, 6.8])"),
                mutableListOf("array(‘d’, [1.1, 2.1, 3.1, 3.4])", "array(‘d’, [1.1, 2.1, 3.1, 3.4, 4.5, 6.3, 6.8])", "array(‘d’, [1.1, 2.1, 3.8, 3.1, 3.4, 4.5, 6.3, 6.8])"),
                true,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                36,
                "What is the difference between “is” and “==”?",
                null,
                mutableListOf("'is' checks identity", "== checks equality", "they are the same", "'is' checks strings"),
                mutableListOf("'is' checks identity", "== checks equality"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                37,
                "How will you convert a string S to a list in python?",
                null,
                null,
                mutableListOf("list(S)"),
                false,
                questionSingletonData.QUESTION_TEXT
            )
        )
    )

    mediumQuestionList.addAll(
        mutableListOf(
            Question(
                11,
                "Suppose a given list [1,2,3,4], what remains after list.pop(1) in Python?",
                null,
                mutableListOf("[2,3,4]", "[1,2,3]", "[1,3,4]"),
                mutableListOf("[1,3,4]"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                12,
                "What is the output of the following code?",
                "medium1.jpg",
                mutableListOf("[‘ab’, ‘cd’]", "[‘AB’, ‘CD’]", "['Ab', 'Cd']"),
                mutableListOf("[‘ab’, ‘cd’]"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                13,
                "Which of the following function is incorrect??",
                null,
                mutableListOf("range(0, 3.5)", "range(10, 4, -1)", "range(1, 3, 1)", "range(2.5, 4.5)"),
                mutableListOf("range(0, 3.5)", "range(2.5, 4.5)"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                14,
                "Can Python functions return multiple variables?",
                null,
                null,
                mutableListOf("yes"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                15,
                "What is the output of the following code?",
                "medium3.jpg",
                mutableListOf("Hello foo and bin", "Hello {name1} and {name2}", "Error", "Hello and"),
                mutableListOf("Hello foo and bin"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                16,
                "Write different ways to initialize an empty list in Python?",
                null,
                null,
                mutableListOf("[]", "=[]", "list()", "=list()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                17,
                "What types can a split() function split?",
                null,
                null,
                mutableListOf("string"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                18,
                "What is the output of the following code?",
                "medium3.jpg",
                mutableListOf("Hello foo and bin", "Hello {name1} and {name2}", "Error", "Hello and"),
                mutableListOf("Hello foo and bin"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                19,
                "How would you convert hexadecimal \"A\" to int using int() function in Python? (without spaces)",
                null,
                null,
                mutableListOf("int(\"A\",16)"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                20,
                "What is the number of iterations in the following loop:",
                "medium4.jpg",
                mutableListOf("2*n", "n", "n+1", "n-1"),
                mutableListOf("n"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                21,
                "How will you randomizes the items of a list LST in place?",
                null,
                null,
                mutableListOf("shuffle(LST)"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                22,
                "How will you capitalizes first letter of string?",
                null,
                mutableListOf("upper()", "capitalize()", "capitalizeLetter()", "capitalizeFirstLetter()"),
                mutableListOf("capitalize()"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                23,
                "How will you convert a string to all uppercase?",
                null,
                null,
                mutableListOf("upper()"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                24,
                "How will you compare two lists in Python?",
                null,
                mutableListOf("compare(list1, list2)", "cmp(list1, list2)", "list1 == list2",  "list1.returnAll(list2)"),
                mutableListOf("cmp(list1, list2)"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                25,
                "What is the output of the folowing code?",
                "medium5.jpg",
                mutableListOf("LEARN PYTHON", "learn python", "lEAN pYTHON",  "Learn Python"),
                mutableListOf("Learn Python"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                26,
                "What is the result of multiplying the string ‘cat’ by 3.?",
                null,
                mutableListOf("cat3", "ERROR", "catcatcat",  "None of the above"),
                mutableListOf("catcatcat"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                27,
                "What is the result of multiplying a list [1,2] by 3?",
                "medium5.jpg",
                mutableListOf("[1,2,1,2]", "[1,2,3]", "ERROR",  "[2,6]"),
                mutableListOf("[1,2,1,2]"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
        )
    )
    easyQuestionList.addAll(
        mutableListOf(
            Question(
                1,
                "Is python case sensitive?",
                null,
                mutableListOf("Yes", "No"),
                mutableListOf("Yes"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                2,
                "What is type conversion for ord() in Python?",
                null,
                mutableListOf("converts characters into integer", "converts integers into character", "converts integers into hexadecimal"),
                mutableListOf("converts characters to integer"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                3,
                "Difference between Ptyhon Arrays and lists?",
                null,
                mutableListOf("Lists have larger storage capacity","Arrays can hold only a single type of data", "There is no object type of array in Python"),
                mutableListOf("Arrays can hold only a single type of data"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                4,
                "What is the output of the following code?",
                "easy1.jpg",
                mutableListOf("type 'int'", "type 'type'", "0", "'Error'"),
                mutableListOf("type 'type'"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                5,
                "What is called when a function is defined inside a class?",
                null,
                mutableListOf("Module", "Class", "Another Function", "Method"),
                mutableListOf("Method"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                6,
                "Which of the following is a logical NOT operator?",
                null,
                mutableListOf("&&", "!", "&", "null"),
                mutableListOf("!"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                7,
                "What is the maximum number of dimensions of array in Python or C++?",
                null,
                mutableListOf("Two", "Eight", "Fifteen", "No limit"),
                mutableListOf("No limit"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                8,
                "Give at least 4 functions that List object supports in Python (example 'reverse')",
                null,
                null,
                mutableListOf("append", "insert", "remove", "pop", "clear", "count", "sort", "copy", "reverse"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                9,
                "Which of these is the correct syntax to increment number by 1 in Python language?",
                null,
                mutableListOf("a+=1", "a++", "a = a + 1", "a =+ 1"),
                mutableListOf("a+=1", "a++", "a = a + 1"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                10,
                "Which of these statements is correct?",
                null,
                mutableListOf("Python is an interpreted language", "Python emphasises code readability", "Python is purely a functional language", "Python's extension is .py"),
                mutableListOf("Python is an interpreted language", "Python emphasises code readability", "Python's extension is .py"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                11,
                "What operator do you use to concatenate two lists?",
                null,
                null,
                mutableListOf("+"),
                false,
                questionSingletonData.QUESTION_TEXT
            ),
            Question(
                12,
                "How to take the absolute value of an integer?",
                null,
                mutableListOf("abs(x)", "absolute(x)", "int(x)", "x.absolute"),
                mutableListOf("abx(x)"),
                false,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                13,
                "What is the output of the following code?",
                "easy3.jpg",
                mutableListOf("ERROR", "5", "23", "3"),
                mutableListOf("5"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                14,
                "What is the output of the following code?",
                "easy4.jpg",
                mutableListOf("aBCD", "abcd", "Abcd", "abcD"),
                mutableListOf("abcd"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            ),
            Question(
                15,
                "What does len() do?",
                null,
                mutableListOf("determine length of the string", "determine length of a list", "determine length of an array"),
                mutableListOf("determine length of the string", "determine length of a list", "determine length of an array"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                16,
                "What are the built-in types of python?",
                null,
                mutableListOf("Lists", "Floating-point", "Boolean", "Built-in functions"),
                mutableListOf("Floating-point", "Boolean", "Built-in functions"),
                false,
                questionSingletonData.QUESTION_MULTIPLE_CHOICE
            ),
            Question(
                17,
                "What is the output of the following code?",
                "easy5.jpg",
                mutableListOf("[‘edureka’, ‘python’]", "edureka python", "['edurekapython']", "edurekapython"),
                mutableListOf("[‘edureka’, ‘python’]"),
                true,
                questionSingletonData.QUESTION_SINGLE_CHOICE
            )
        )
    )

    return Triple(easyQuestionList, mediumQuestionList, hardQuestionList)
}