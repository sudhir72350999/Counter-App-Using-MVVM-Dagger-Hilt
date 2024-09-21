package com.example.counterappusingdaggerhilt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.counterappusingdaggerhilt.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Inject ViewModel using Hilt
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe changes in counter and update UI
        counterViewModel.counterValue.observe(this, Observer {
            binding.tvCounter.text = it.count.toString()
        })


        // Set up button click listeners
        binding.btnIncrement.setOnClickListener {
            counterViewModel.increment()
        }



        binding.btnDecrement.setOnClickListener {
            counterViewModel.decrement()
        }

        binding.btnDecrement.setOnClickListener {
            counterViewModel.increment()
        }
    }
}
