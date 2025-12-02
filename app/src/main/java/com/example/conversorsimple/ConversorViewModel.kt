package com.example.conversorsimple

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ConversorViewModel : ViewModel() {
    private val _valorEntrada = mutableStateOf("")
    val valorEntrada: State<String> = _valorEntrada
    private val _resultado = mutableStateOf("")
    val resultado: State<String> = _resultado


    fun onValueChange(value: String) {
        _valorEntrada.value = value
    }

    fun convertToFarenheit() {
        val celsius = valorEntrada.value.toDoubleOrNull()
        _resultado.value =
            if (celsius != null) {
                "${calculoCelsiusToFahrenheit(celsius)}ºF"
            } else {
                "Entrada inválida"
            }
    }

    fun convertToCelsius() {
        val farenheit = valorEntrada.value.toDoubleOrNull()
        _resultado.value =
            if (farenheit != null) {
                "${calculoFahrenheitToCelsius(farenheit)}ºC"
            } else {
                "Entrada inválida"
            }
    }

   private fun calculoCelsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 1.8) + 32

   }
  private  fun calculoFahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) / 1.8

  }

}