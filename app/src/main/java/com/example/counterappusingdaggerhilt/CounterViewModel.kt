package com.example.counterappusingdaggerhilt



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CounterViewModel @Inject constructor(private val counter: Counter) : ViewModel() {

    private val _counterValue = MutableLiveData(counter)
    val counterValue: LiveData<Counter> get() = _counterValue

    fun increment() {
        counter.count++
        _counterValue.value = counter
    }

    fun decrement() {
        counter.count--
        _counterValue.value = counter
    }
}
