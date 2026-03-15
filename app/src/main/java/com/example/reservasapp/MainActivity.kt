package com.example.reservasapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvCupos: TextView
    private lateinit var tvEstado: TextView
    private lateinit var btnReservar: Button
    private val viewModel: ReservaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCupos = findViewById(R.id.tvCupos)
        tvEstado = findViewById(R.id.tvEstado)
        btnReservar = findViewById(R.id.btnReservar)

        viewModel.cupos.observe(this) { cantidad ->
            tvCupos.text = "Cupos restantes: $cantidad"
        }

        viewModel.mensaje.observe(this) { texto ->
            tvEstado.text = texto
        }

        viewModel.botonHabilitado.observe(this) { estaHabilitado->
            btnReservar.isEnabled = estaHabilitado
        }

        btnReservar.setOnClickListener {
            viewModel.reservarAsiento()
        }
    }
}

