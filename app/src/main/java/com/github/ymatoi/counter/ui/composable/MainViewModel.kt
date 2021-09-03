package com.github.ymatoi.counter.ui.composable

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter

    val increment = { _counter.value += 1 }
    val decrement = { _counter.value -= 1 }
}