package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers.allOf

class TodoListScreen : BaseScreen() {

    private val newTaskFabButton = onView(withId(R.id.fab_add_task))
    private val menuFilterButton = onView(withId(R.id.menu_filter))

    private val clearCompletedMenuTile = onView(allOf(withId(R.id.title), withText(R.string.menu_clear)))
    private val refreshMenuTile = onView(allOf(withId(R.id.title), withText(R.string.refresh)))
    private val shareMenuTile = onView(allOf(withId(R.id.title), withText(R.string.share)))

    private val allFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_all)))
    private val activeFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_active)))
    private val completedFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_completed)))

    private val snackbar = onView(withId(android.support.design.R.id.snackbar_text))

    fun selectClearCompletedFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        clearCompletedMenuTile.perform(click())
        checkIfTasksClearedSnackbarIsVisible()
        return TodoListScreen()
    }

    fun selectRefreshFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        refreshMenuTile.perform(click())
        return TodoListScreen()
    }

    fun selectShareFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        shareMenuTile.perform(click())
        return TodoListScreen()
        //TODO Temporary solution. In the future Implement system 'Share to' PO model to interact with system items
    }

    fun showAllTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        allFilterTile.perform(click())
        return TodoListScreen()
    }

    fun showActiveTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        activeFilterTile.perform(click())
        return TodoListScreen()
    }

    fun showCompletedTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        completedFilterTile.perform(click())
        return TodoListScreen()
    }

    fun clickOnFABButton(): AddEditTaskScreen {
        newTaskFabButton.perform(click())
        return AddEditTaskScreen()
    }

    fun clickOnMenuFilterButton(): TodoListScreen {
        menuFilterButton.perform(click())
        return TodoListScreen()
    }

    fun checkIfTasksClearedSnackbarIsVisible(): TodoListScreen {
        snackbar.check(matches(isDisplayed()))
                .check(matches(withText(R.string.completed_tasks_cleared)))
        return TodoListScreen()
    }

    fun checkIfToDoSavedSnackbarIsVisible(): TodoListScreen {
        snackbar.check(matches(isDisplayed()))
                .check(matches(withText(R.string.successfully_saved_task_message)))
        return TodoListScreen()
    }
}