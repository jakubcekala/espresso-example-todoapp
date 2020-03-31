package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R
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
        clearCompletedMenuTile.perform(click())
    }

    fun selectRefreshFromContextualMenu() {
        openContextualActionModeOverflowMenu()
        refreshMenuTile.perform(click())
    }

    fun selectShareFromContextualMenu() {
        openContextualActionModeOverflowMenu()
        shareMenuTile.perform(click())
    }

    fun showAllTasks() {
        clickOnMenuFilterButton()
        allFilterTile.perform(click())
    }

    fun showActiveTasks() {
        clickOnMenuFilterButton()
        activeFilterTile.perform(click())
    }

    fun showCompletedTasks() {
        clickOnMenuFilterButton()
        completedFilterTile.perform(click())
    }

    fun selectAllTasksFilter() {
        clickOnMenuFilterButton()
    }

    fun clickOnFABButton(): AddEditTaskScreen {
        newTaskFabButton.perform(click())
        return AddEditTaskScreen()
    }

    fun clickOnMenuFilterButton() {
        menuFilterButton.perform(click())
    }
}
