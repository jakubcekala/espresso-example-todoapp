package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.InstrumentationRegistry
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

    private val statisticEmptyTextView = onView(allOf(withId(R.id.statistics), withText(R.string.statistics_no_tasks)))
    private val statisticHeader = onView(allOf(withParent(withId(R.id.toolbar)), withText(R.string.statistics_title)))

    fun clickOkAlertDialog(): StatisticsScreen {
        okDialogButton.perform(click())
        return StatisticsScreen()
    }

    fun clickCancelAlertDialog(): StatisticsScreen {
        cancelDialogButton.perform(click())
        return StatisticsScreen()
    }

    fun checkAlertDialogDisplay(): StatisticsScreen {
        alertTitle.check(matches(isDisplayed()))
        alertMessageTextView.check(matches(isDisplayed()))
        return StatisticsScreen()
    }

    fun checkAlertDialogNotDisplayed(): StatisticsScreen {
        alertTitle.check(matches(not(isDisplayed())))
        alertMessageTextView.check(matches(not(isDisplayed())))
        return StatisticsScreen()
    }

    fun verifyEmptyStatisticScreen(): StatisticsScreen {
        statisticEmptyTextView.check(matches(isDisplayed()))
        statisticHeader.check(matches(isDisplayed()))
        return StatisticsScreen()
    }

    fun verifyNotEmptyStatisticScreen(activeTask: Int, completedTasks: Int): StatisticsScreen {
        val statisticNotEmptyTextView = onView(allOf(withText(
                InstrumentationRegistry.getInstrumentation().targetContext.resources.
                    getString(R.string.statistics_active_tasks) + " " + activeTask + "\n" +
                InstrumentationRegistry.getInstrumentation().targetContext.resources.
                    getString(R.string.statistics_completed_tasks) + " " + completedTasks)))
        statisticNotEmptyTextView.check(matches(isDisplayed()))
        statisticHeader.check(matches(isDisplayed()))
        return StatisticsScreen()
    }
}
