package com.zubisoft.android.quizapp

object Constants {

    fun getQuestions():ArrayList<Question>{
        val questions=ArrayList<Question>()

        val quest1=Question(
            1,
            "Which of these best describes an array?",
            0,
            mutableListOf<String>("A data structure that shows a hierarchical behavior",
            "Container of objects of similar types",
            "Arrays are immutable once initialised",
            "Array is not a data structure"),
            1
        )

        val quest2=Question(
            2,
            "How do you initialize an array in C?",
            0,
            mutableListOf<String>("int arr[3] = (1,2,3);",
            "int arr(3) = {1,2,3};",
            "int arr[3] = {1,2,3};",
            "int arr(3) = (1,2,3);"),
            2
        )

        val quest3=Question(
            3,
            "How do you instantiate an array in Java?",
            0,
            mutableListOf<String>("int arr[] = new int(3);",
            "int arr[];",
            "int arr[] = new int[3];",
            "int arr() = new int(3);"),
            2
        )

        val quest4=Question(
            4,
            " Which of the following is the correct way to declare a multidimensional array in Java?",
            0,
            mutableListOf<String>("int[] arr;",
            "int arr[[]];",
            "int[][]arr;",
            "int[[]] arr;"),
            2
        )

        questions.add(quest1)
        questions.add(quest2)
        questions.add(quest3)
        questions.add(quest4)

        return questions
    }

}