package com.example.conversorsimple
import org.junit.Assert.assertEquals
import org.junit.Test


class ConversorViewModelTest {
    private val viewModel = ConversorViewModel()

    @Test
    fun testCelsiusToFahrenheit() {
        viewModel.onValueChange("10")
        viewModel.convertToFarenheit()

        assertEquals("50.0ºF", viewModel.resultado.value)
    }
    @Test
    fun testFahrenheitToCelsius() {
        viewModel.onValueChange("32")
        viewModel.convertToCelsius()
        assertEquals("0.0ºC", viewModel.resultado.value)
    }

    @Test
    fun testNegativeCelsiusToFahrenheit() {
        viewModel.onValueChange("-40")
        viewModel.convertToFarenheit()
        assertEquals("-40.0ºF", viewModel.resultado.value)
    }

    @Test
    fun testEntradaInvalida() {
        viewModel.onValueChange("abc")
        viewModel.convertToFarenheit()
        assertEquals("Entrada inválida", viewModel.resultado.value)
    }
}