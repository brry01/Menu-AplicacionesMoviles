package com.example.menu

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FormularioAlumnos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario_alumnos)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCarrera = findViewById<Spinner>(R.id.spinnerCarrera)
        val rgTurno = findViewById<RadioGroup>(R.id.rgTurno)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnVolver = findViewById<Button>(R.id.btnVolverMenuFormulario)

        val carreras = arrayOf(
            "Selecciona una carrera",
            "Sistemas Embebidos",
            "Mecatrónica",
            "Industrial",
            "Diseño Industrial"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            carreras
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarrera.adapter = adapter

        btnMostrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val turnoSeleccionadoId = rgTurno.checkedRadioButtonId

            if (nombre.isEmpty()) {
                etNombre.error = "El nombre no puede estar vacío."
                return@setOnClickListener
            }

            if (spinnerCarrera.selectedItemPosition == 0) {
                Toast.makeText(this, "Por favor, selecciona una carrera válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (turnoSeleccionadoId == -1) {
                Toast.makeText(this, "Debes seleccionar un turno.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rbTurno = findViewById<RadioButton>(turnoSeleccionadoId)
            val turno = rbTurno.text.toString()
            val carreraSeleccionada = spinnerCarrera.selectedItem.toString()

            val resumen = "Nombre: $nombre\nCarrera: $carreraSeleccionada\nTurno: $turno"
            tvResumen.text = resumen
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}