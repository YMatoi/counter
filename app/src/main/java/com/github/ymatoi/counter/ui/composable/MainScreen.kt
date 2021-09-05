package com.github.ymatoi.counter.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(fontSize = 64.sp, text = "$count")
        Row {
            Button(
                onClick = onClickIncrement,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "+")
            }
            Button(
                onClick = onClickDecrement,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "-")
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(0, {}, {})
}