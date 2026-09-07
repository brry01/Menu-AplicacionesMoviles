package com.example.menu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnArea=findViewById<Button>(R.id.btnArea)
        val btnPeliculas = findViewById<Button>(R.id.btnPeliculas)
        val btnIMC = findViewById<Button>(R.id.btnIMC)

        btnArea.setOnClickListener {
            val intent=Intent(this,AreaActivity::class.java)
            startActivity(intent)
        }

        btnPeliculas.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        btnIMC.setOnClickListener {
            val intent = Intent(this, IMC_Calculator::class.java)
            startActivity(intent)
        }
    }
}