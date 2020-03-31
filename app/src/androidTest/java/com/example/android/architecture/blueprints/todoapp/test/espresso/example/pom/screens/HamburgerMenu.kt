package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.chapter3.checkDisplayed
import com.example.android.architecture.blueprints.todoapp.test.chapter3.click
import org.hamcrest.CoreMatchers.allOf

class HamburgerMenu : ScreenObject() {

    private val todoButton = onView(allOf(withId(R.id.design_menu_item_text),
            withText(R.string.list_title)))
    private val statisticsButton = onView(allOf(withId(R.id.design_menu_item_text),
            withText(R.string.statistics_title)))
    private val settingsButton = onView(allOf(withId(R.id.design_menu_item_text),
            withText(R.string.settings_title)))
    private val navView = onView(withId(R.id.nav_view))

    fun clickOnTodoButton(): TodoListScreen {
        verifyHamburgerMenuDisplay()
        todoButton.click()
        return TodoListScreen()
    }

    fun clickOnStatisticsButton(): StatisticsScreen {
        verifyHamburgerMenuDisplay()
        statisticsButton.click()
        return StatisticsScreen()
    }

    fun clickOnSettingsButton(): SettingsScreen {
        verifyHamburgerMenuDisplay()
        settingsButton.click()
        return SettingsScreen()
    }

    fun closeHamburgerMenu(): BaseScreen {
        verifyHamburgerMenuDisplay()
        navView.perform(swipeLeft())
        return BaseScreen()
    }

    private fun verifyHamburgerMenuDisplay() {
        todoButton.checkDisplayed()
        statisticsButton.checkDisplayed()
        settingsButton.checkDisplayed()
        navView.checkDisplayed()
    }
}
