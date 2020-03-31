package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.chapter3.click
import org.hamcrest.CoreMatchers.allOf

class TodoListScreen {

    private val newTaskFabButton = onView(withId(R.id.fab_add_task))
    private val menuFilterButton = onView(withId(R.id.menu_filter))

    private val clearCompletedMenuTile = onView(allOf(withId(R.id.title), withText(R.string.menu_clear)))
    private val refreshMenuTile = onView(allOf(withId(R.id.title), withText(R.string.refresh)))
    private val shareMenuTile = onView(allOf(withId(R.id.title), withText(R.string.share)))

    private val allFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_all)))
    private val activeFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_active)))
    private val completedFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_completed)))

    fun selectClearCompletedFromContextualMenu() {
        openContextualActionModeOverflowMenu()
        clearCompletedMenuTile.click()
    }

    fun selectRefreshFromContextualMenu() {
        openContextualActionModeOverflowMenu()
        refreshMenuTile.click()
    }

    fun selectShareFromContextualMenu() {
        openContextualActionModeOverflowMenu()
        shareMenuTile.click()
    }

    fun showAllTasks() {
        clickOnMenuFilterButton()
        allFilterTile.click()
    }

    fun showActiveTasks() {
        clickOnMenuFilterButton()
        activeFilterTile.click()
    }

    fun showCompletedTasks() {
        clickOnMenuFilterButton()
        completedFilterTile.click()
    }

    fun selectAllTasksFilter() {
        clickOnMenuFilterButton()
    }

    fun clickOnFABButton(): AddEditTaskScreen {
        newTaskFabButton.click()
        return AddEditTaskScreen()
    }

    fun clickOnMenuFilterButton() {
        menuFilterButton.click()
    }
}
