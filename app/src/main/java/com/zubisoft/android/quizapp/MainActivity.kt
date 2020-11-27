package com.zubisoft.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener{
            if (TextUtils.isEmpty(txtName.text)){
                txtNameLayout.error="Name must not be empty"
            }else{
                val intent = Intent(this, QuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        txtName.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isEmpty()){
                    txtNameLayout.error="Name must not be empty"
                }else{
                    txtNameLayout.error=null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }
}