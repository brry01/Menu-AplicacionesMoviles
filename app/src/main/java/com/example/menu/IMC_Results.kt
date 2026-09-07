package com.example.menu

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMC_Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_results)
        val tvResultadoIMC=findViewById<TextView>(R.id.tvResultadoIMC)
        val tvClasificacion=findViewById<TextView>(R.id.tvClasificacion)
        val btnRegIMC=findViewById<Button>(R.id.btnRegIMC)
        val imc = intent.getDoubleExtra("IMC",0.0)
        val clasificacion=if(imc<18.5) {
            "Bajo Peso"
        }
        else if (imc<25.0) {
            "Peso normal"
        }
        else if (imc<30.0) {
            "Sobrepeso"
        }
        else {
            "Obesidad"
        }
        tvResultadoIMC.text=String.format("IMC: %.2f",imc)
        tvClasificacion.text="Clasificación: $clasificacion"
        btnRegIMC.setOnClickListener {
            finish()
        }
    }
}