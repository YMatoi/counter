package com.github.ymatoi.counter.ui.composable

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var target: MainViewModel

    @Before
    fun setUp() {
        target = MainViewModel()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isValid() = runBlocking {
        val firstItem = target.counter.first()
        assertTrue(firstItem == 0)
    }

    @Test
    fun isIncremented() = runBlocking {
        target.increment()
        val firstItem = target.counter.first()
        assertTrue(firstItem == 1)
    }

    @Test
    fun isDecrement() = runBlocking {
        target.decrement()
        val firstItem = target.counter.first()
        assertTrue(firstItem == -1)
    }
    @Test
    fun `increment 10 times`() = runBlocking {
        (1..10).forEach {
            target.increment()
        }
        val firstItem = target.counter.first()
        assertTrue(firstItem == 10)
    }
}