package com.example.reservasapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservaViewModel: ViewModel() {
    private val _numero = MutableLiveData(20)
    val numero: LiveData<Int>get() = _numero

    fun reservar(){
        val actual = _numero.value?:0
        if (actual>0) _numero.value = actual-1
    }
    fun agotar(){
            val actual = _numero.value?:0
            if (actual==0){
                _
            }
    }
}