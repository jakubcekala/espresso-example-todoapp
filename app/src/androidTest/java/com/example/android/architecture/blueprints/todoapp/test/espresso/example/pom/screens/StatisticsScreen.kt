package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not

class StatisticsScreen : BaseScreen() {
    private val okDialogButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
    private val cancelDialogButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))
    private val alertTitle = onView(withId(R.id.alertTitle))
    private val alertMessageTextView = onView(withId(android.R.id.message))

    private val statisticTextView = onView(allOf(withId(R.id.statistics), withText(R.string.statistics_no_tasks)))
    private val statisticHeader = onView(allOf(withParent(withId(R.id.toolbar)), withText(R.string.statistics_title)))

    fun clickOkAlertDialog() {
        okDialogButton.perform(click())
    }

    fun clickCancelAlertDialog() {
        cancelDialogButton.perform(click())
    }

    fun checkAlertDialogDisplay() {
        alertTitle.check(matches(isDisplayed()))
        alertMessageTextView.check(matches(isDisplayed()))
    }

    fun checkAlertDialogNotDisplayed() {
        alertTitle.check(matches(not(isDisplayed())))
        alertMessageTextView.check(matches(not(isDisplayed())))
        
    }

    fun verifyStatisticScreen() {
        statisticTextView.check(matches(isDisplayed()))
        statisticHeader.check(matches(isDisplayed()))
    }
}
