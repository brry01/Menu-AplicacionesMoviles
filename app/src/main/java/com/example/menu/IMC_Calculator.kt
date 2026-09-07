package com.example.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IMC_Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        val etPeso=findViewById<EditText>(R.id.etPeso)
        val etEstatura=findViewById<EditText>(R.id.etEstatura)
        val btnIMC=findViewById<Button>(R.id.btnIMC)
        val btnReg=findViewById<Button>(R.id.btnReg)
        btnIMC.setOnClickListener {
            val peso=etPeso.text.toString().toDoubleOrNull()
            val estatura=etEstatura.text.toString().toDoubleOrNull()
            if (peso == null || estatura == null || estatura <= 0 || peso <= 0) {
                if (peso == null) {
                    etPeso.error="Ingrese un peso válido."
                }
                if (estatura == null) {
                    etEstatura.error="Ingrese una estatura válida."
                }
                return@setOnClickListener
            }
            val imc=peso/(estatura*estatura)
            val intent= Intent(this, IMC_Results::class.java)
            intent.putExtra("IMC",imc)
            startActivity(intent)
        }
        btnReg.setOnClickListener {
            finish()
        }

    }
}