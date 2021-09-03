package com.github.ymatoi.counter.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    val count by viewModel.counter.collectAsState()
    MainScreen(count, viewModel.increment, viewModel.decrement)
}

@Composable
fun MainScreen(
    count: Int,
    onClickIncrement: ()->Unit = {},
    onClickDecrement: ()->Unit = {},
) {
    Column {
        Button(onClick = onClickIncrement) {
            Text(text = "Increment")
        }
        Text(text = "$count")
        Button(onClick = onClickDecrement) {
            Text(text = "Decrement")
        }
    }
}