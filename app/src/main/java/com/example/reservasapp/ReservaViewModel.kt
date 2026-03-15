package com.example.reservasapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservaViewModel: ViewModel() {
    private val _cupos = MutableLiveData(20)
    val cupos: LiveData<Int>get() = _cupos

    private val _botonHabilitado = MutableLiveData(true)
    val botonHabilitado: LiveData<Boolean> get() = _botonHabilitado

    private val _mensaje = MutableLiveData("Asientos libres")
    val mensaje: LiveData<String> get() = _mensaje

    fun reservarAsiento(){
        val cantidadActual = _cupos.value?: 0

        if (cantidadActual > 0) {
            val nuevaCantidad = cantidadActual - 1
            _cupos.value = nuevaCantidad

            if (nuevaCantidad == 0) {
                _mensaje.value = "Agotado"
                _botonHabilitado.value = false
            }

        }

    }
}