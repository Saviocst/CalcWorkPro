package com.example.calcworkpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    lateinit var cardCalc: CardView
    lateinit var cardAcord: CardView
    lateinit var cardSair: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_layout_main)

        cardCalc = findViewById(R.id.card_work_calc)
        cardAcord = findViewById(R.id.card_work_simul)
        cardSair = findViewById(R.id.card_work_sair)

        cardCalc.setOnClickListener {
            startActivity(Intent(this, WorkProActivity::class.java))
        }

        cardAcord.setOnClickListener {
            finish()
        }

        cardSair.setOnClickListener {
            finish()
        }

    }
}