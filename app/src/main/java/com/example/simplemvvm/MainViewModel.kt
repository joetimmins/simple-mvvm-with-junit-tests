package com.example.simplemvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(
    private val initialState: MainUiState
) : ViewModel() {
    private val _uiState = MutableLiveData(initialState)
    val uiState = _uiState as LiveData<MainUiState>

    fun addOne() {}

    fun addTwo() {}

    fun reset() {}
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val initialState = MainUiState(89)
        val viewModel = MainViewModel(initialState)
        return modelClass.cast(viewModel)!!
    }
}

data class MainUiState(
    val total: Int
)