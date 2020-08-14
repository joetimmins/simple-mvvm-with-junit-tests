package com.example.simplemvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.simplemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val initialState = MainUiState(23)

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(initialState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.addOne.setOnClickListener {
            viewModel.addOne()
        }

        binding.addTwo.setOnClickListener {
            viewModel.addTwo()
        }

        binding.reset.setOnClickListener {
            viewModel.reset()
        }

        viewModel.uiState.observe(this, Observer {
            if (it != null) binding.total.text = it.total.toString()
        })

        setContentView(binding.root)
    }
}