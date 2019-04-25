package com.katacalc.kotlin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @Suppress("unused")
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    @Throws(Exception::class)
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun `when 9 is pressed, result equals 9`() {
        // Given
        val amount = 9

        // When
        viewModel.numberPressed(amount)

        // Then
        assertEquals("$amount", viewModel.getFormula().value)
    }

    @Test
    fun `when 99 is pressed, result equals 99`() {

        // Given
        val amount = 99

        // When
        viewModel.numberPressed(9)
        viewModel.numberPressed(9)

        // Then
        assertEquals("$amount", viewModel.getFormula().value)
    }

    @Test
    fun `when number is pressed and clear is pressed after, formula is blank`() {

        // Given & When
        viewModel.numberPressed(9)
        viewModel.handleClear()

        // Then
        assertEquals("", viewModel.getFormula().value)
    }

    @Test
    fun `when a plus sign is pressed, formula displays + within formula`() {
        // Given
        val plusPressed = "+"

        // When
        viewModel.operatorPressed("+")

        // Then
        assertEquals(plusPressed, viewModel.getFormula().value)
    }

    @Test
    fun `when nothing but equals is pressed, 0 should be shown in result`(){
        // Given
        val result = "0"

        // When
        viewModel.handleEquals()

        // Then
        assertEquals(result, viewModel.getResult().value)
    }

    @Test
    fun `when nothing but 1 is pressed, 1 should be shown in result after pressing equals`(){
        // Given
        val result = "1"

        // When
        viewModel.numberPressed(1)
        viewModel.handleEquals()

        // Then
        assertEquals(result, viewModel.getResult().value)
    }
    @Test
    fun `when 1 + 2 is pressed, 3 should be shown in result`() {
        // Given
        val result = "3"

        // When
        viewModel.numberPressed(1)
        viewModel.operatorPressed("+")
        viewModel.numberPressed(2)
        viewModel.handleEquals()

        // Then
        assertEquals(result, viewModel.getResult().value)
    }
}