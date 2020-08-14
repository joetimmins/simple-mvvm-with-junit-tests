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

    fun addOne() {
        val current = _uiState.value ?: return
        val updated = current.copy(total = current.total + 1)
        _uiState.postValue(updated)
    }

    fun addTwo() {
        val current = _uiState.value ?: return
        val updated = current.copy(total = current.total + 2)
        _uiState.postValue(updated)
    }

    fun reset() {
        _uiState.postValue(initialState)
    }
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