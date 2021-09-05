package com.github.ymatoi.counter.ui.composable

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.github.ymatoi.counter.ui.theme.NoteTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            NoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //MainScreen(count = 0, onClickDecrement = {}, onClickIncrement = {})
                    MainScreen()
                }
            }
        }
    }

    @Test
    fun MyTest() {
        composeTestRule.onRoot(true).printToLog("TAG")
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("1").assertIsDisplayed()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("0").assertIsDisplayed()
    }
}