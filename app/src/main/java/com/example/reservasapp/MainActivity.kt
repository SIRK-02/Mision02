package com.example.reservasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val miViewModel: ReservaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvContador: TextView = findViewById(R.id.tvContador)
        val btnRestar: Button = findViewById(R.id.btnRestar)

        miViewModel.numero.observe(this){valorActualizado->
            tvContador.text = if (valorActualizado == 0) "Agotado" else valorActualizado.toString()
        }

        miViewModel.botonHabilitado.observe(this){habilitado ->
            btnRestar.isEnabled = habilitado
        }

        btnRestar.setOnClickListener { miViewModel.reservar() }
    }
}

