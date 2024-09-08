package com.example.app_sem3_s1_geoquizwx64

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadQuestions()// Cargar las preguntas
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("Es lima capital de Peru?", true))
        questions.add(Question("Es carabayllo capital de China?", false))
        questions.add(Question("Es Tokyo capital de Japon?", true))
        questions.add(Question("Es Barranco capital de Argentina?", false))
    }

    private fun setupViews() {
        //1. Vincular los components UI con la logica
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[position].sentence

        btYes.setOnClickListener {
            if(questions[position].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNo.setOnClickListener {
            if(!questions[position].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNext.setOnClickListener {
            position++
            if (position == questions.size) {
                position = 0
            }
            tvQuestion.text = questions[position].sentence
        }

    }
}