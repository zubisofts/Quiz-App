package com.zubisoft.android.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.ArrayList

class QuestionsActivity : AppCompatActivity() {

    private val TAG = "QuestionsActivity"

    private var currentIndex = 0
    private val questions = Constants.getQuestions()
    private var correctAnswers=ArrayList<Question>()
    private var answeredQuestions=HashSet<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        setQuestion(questions, currentIndex)

        initOptions(questions)

        btnNext.setOnClickListener {
            if (currentIndex < questions.size - 1) {
                currentIndex++
                setQuestion(questions, currentIndex)
                resetOptions()
                submitResult()
            }
        }
    }

    private fun submitResult() {

    }

    private fun resetOptions() {
        for (i in 0 until options_cont.childCount) {
            val card = options_cont.getChildAt(i) as MaterialCardView;
            card.strokeColor = Color.parseColor("#C7B299")
            val ll_op = card.getChildAt(0) as LinearLayout
            (ll_op.getChildAt(1) as CheckBox).isChecked = false
        }
    }

    private fun initOptions(questions: ArrayList<Question>) {
        option1.setOnClickListener {
            if (answeredQuestions.contains(questions[currentIndex]))
                Toast.makeText(this,"Question already answered",Toast.LENGTH_SHORT).show()
            else
            setActiveOption(0)
        }
        option2.setOnClickListener {
            if (answeredQuestions.contains(questions[currentIndex]))
                Toast.makeText(this,"Question already answered",Toast.LENGTH_SHORT).show()
            else
                setActiveOption(1)
        }
        option3.setOnClickListener {
            if (answeredQuestions.contains(questions[currentIndex]))
                Toast.makeText(this,"Question already answered",Toast.LENGTH_SHORT).show()
            else
                setActiveOption(2)
        }
        option4.setOnClickListener {
            if (answeredQuestions.contains(questions[currentIndex]))
                Toast.makeText(this,"Question already answered",Toast.LENGTH_SHORT).show()
            else
                setActiveOption(3)
        }
    }

    private fun setActiveOption(index: Int) {
        for (i in 0 until options_cont.childCount) {
            val card = options_cont.getChildAt(i) as MaterialCardView;
            if (i == index) {
                card.strokeColor = Color.GREEN
                val ll_op = card.getChildAt(0) as LinearLayout
                (ll_op.getChildAt(1) as CheckBox).isChecked = true
                correctAnswers.add(questions[currentIndex])
            } else {
                card.strokeColor = Color.parseColor("#C7B299")
                val ll_op = card.getChildAt(0) as LinearLayout
                (ll_op.getChildAt(1) as CheckBox).isChecked = false
            }
        }

        setCorrectAnswer(index)

        if(currentIndex==questions.size-1){
            btnNext.text="Submit"
        }

    }

    private fun setCorrectAnswer(index: Int) {
        val card = options_cont.getChildAt(questions[currentIndex].answer) as MaterialCardView;
        card.strokeColor = Color.GREEN
        val ll_op = card.getChildAt(0) as LinearLayout
        (ll_op.getChildAt(1) as CheckBox).isChecked = true

        if (index != questions[currentIndex].answer) {
            val card = options_cont.getChildAt(index) as MaterialCardView;
            card.strokeColor = Color.RED
            val ll_op = card.getChildAt(0) as LinearLayout
            (ll_op.getChildAt(1) as CheckBox).isChecked = false
        }

        answeredQuestions.add(questions[currentIndex])
    }

    private fun setQuestion(questions: ArrayList<Question>, currentIndex: Int) {
        txtCount.text = "Question ${currentIndex + 1}/${questions.size}"

        val question: Question = questions.get(currentIndex)
        txtQuestion.text = question.question
        txtOption1.text = question.options[0]
        txtOption2.text = question.options[1]
        txtOption3.text = question.options[2]
        txtOption4.text = question.options[3]
    }


}