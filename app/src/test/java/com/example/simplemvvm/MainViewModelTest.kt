package com.example.simplemvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule() // live data doesn't work in tests without this

    private val initialState = MainUiState(0)

    @Test
    fun `given initial state is zero, when adding one, total is one`() {
        val expected = MainUiState(1)
        var actual: MainUiState? = null

        val viewModel = createViewModel()
        viewModel.uiState.observeForever { actual = it }

        viewModel.addOne()

        assertEquals(expected, actual)
    }

    @Test
    fun `given initial state is zero, when adding two, total is two`() {
        val expected = MainUiState(2)
        var actual: MainUiState? = null

        val viewModel = createViewModel()
        viewModel.uiState.observeForever { actual = it }

        viewModel.addTwo()

        assertEquals(expected, actual)
    }

    @Test
    fun `given initial state is zero, after adding and resetting, total is zero`() {
        var actual: MainUiState? = null

        val viewModel = createViewModel()
        viewModel.uiState.observeForever { actual = it }

        viewModel.addOne()
        viewModel.addTwo()
        viewModel.reset()

        assertEquals(initialState, actual)
    }

    private fun createViewModel() = MainViewModel(initialState)
}