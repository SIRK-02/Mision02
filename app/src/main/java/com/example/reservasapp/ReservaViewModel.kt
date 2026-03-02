package com.example.reservasapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservaViewModel: ViewModel() {
    private val _numero = MutableLiveData(20)
    val numero: LiveData<Int>get() = _numero

    private val _botonHabilitado = MutableLiveData(true)
    val botonHabilitado: LiveData<Boolean> get() = _botonHabilitado

    fun reservar(){
        val actual = _numero.value?: 0

        if (actual>0) {
            val nuevoValor = actual-1
            _numero.value = nuevoValor

            if (nuevoValor == 0) {
                _botonHabilitado.value = false
            }

        }

    }
}