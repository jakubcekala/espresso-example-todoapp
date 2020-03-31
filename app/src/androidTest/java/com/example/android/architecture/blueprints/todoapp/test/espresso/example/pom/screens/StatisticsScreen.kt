package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.chapter3.checkDisplayed
import com.example.android.architecture.blueprints.todoapp.test.chapter3.checkNotDisplayed
import com.example.android.architecture.blueprints.todoapp.test.chapter3.click
import org.hamcrest.CoreMatchers.allOf

class StatisticsScreen {
    private val okDialogButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
    private val cancelDialogButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))
    private val alertTitle = onView(withId(R.id.alertTitle))
    private val alertMessageTextView = onView(withId(android.R.id.message))

    private val statisticTextView = onView(allOf(withId(R.id.statistics), withText(R.string.statistics_no_tasks)))
    private val statisticHeader = onView(allOf(withParent(withId(R.id.toolbar)), withText(R.string.statistics_title)))

    fun clickOkAlertDialog() {
        okDialogButton.click()
    }

    fun clickCancelAlertDialog() {
        cancelDialogButton.click()
    }

    fun checkAlertDialogDisplay() {
        alertTitle.checkDisplayed()
        alertMessageTextView.checkDisplayed()
    }

    fun checkAlertDialogNotDisplayed() {
        alertTitle.checkNotDisplayed()
        alertMessageTextView.checkNotDisplayed()
    }

    fun verifyStatisticScreen() {
        statisticTextView.checkDisplayed()
        statisticHeader.checkDisplayed()
    }
}
