package com.example.conversorsimple

import org.junit.Assert.*
import org.junit.Test

class ConversorViewModelTest {

    private val viewModel = ConversorViewModel()

    // CASOS DE ÉXITO (happy path)
    @Test
    fun convertirCelsiusAFahrenheit() {
        viewModel.onValueChange("0")
        viewModel.convertToFarenheit()
        assertEquals("32.0ºF", viewModel.resultado.value)
    }

    @Test
    fun convertirFahrenheitACelsius() {
        viewModel.onValueChange("32")
        viewModel.convertToCelsius()
        assertEquals("0.0ºC", viewModel.resultado.value)
    }

    // CASOS DE ERROR (error path)
    @Test
    fun entradaInvalidaDevuelveMensajeError() {
        viewModel.onValueChange("abc")
        viewModel.convertToFarenheit()
        assertEquals("Entrada inválida", viewModel.resultado.value)
    }

    // CASOS LÍMITE (boundary case)
    @Test
    fun convertirMenos40CelsiusAFahrenheit() {
        viewModel.onValueChange("-40")
        viewModel.convertToFarenheit()
        assertEquals("-40.0ºF", viewModel.resultado.value) // caso especial: -40 es igual en ambas escalas
    }

    @Test
    fun convertirMenos40FahrenheitACelsius() {
        viewModel.onValueChange("-40")
        viewModel.convertToCelsius()
        assertEquals("-40.0ºC", viewModel.resultado.value)
    }
}
