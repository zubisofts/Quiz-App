package com.zubisoft.android.quizapp

data class Question (
    val id:Int,
    val question:String,
    val image:Int,
    val options:List<String>,
    val answer:Int
    )