package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.StatisticsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import org.junit.Before
import org.junit.Test

class StatisticsScreenTests: BaseTest() {

    private lateinit var statisticsScreen: StatisticsScreen

    @Before
    fun goToStatisticScreen() {
        statisticsScreen = TodoListScreen()
                .openHamburgerMenu()
                .clickOnStatisticsButton()
    }

    @Test
    fun dismissAlertDialogCancel() {
        statisticsScreen
                .checkAlertDialogDisplay()
                .clickCancelAlertDialog()
    }

    @Test
    fun dismissAlertDialogOK() {
        statisticsScreen
                .checkAlertDialogDisplay()
                .clickOkAlertDialog()
    }

    @Test
    fun statisticEmptyScreen() {
        statisticsScreen
                .clickOkAlertDialog()
                .verifyEmptyStatisticScreen()
    }
}