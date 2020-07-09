package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers.*
import java.lang.Exception

class TodoListScreen : BaseScreen() {

    private val newTaskFabButton = onView(withId(R.id.fab_add_task))
    private val menuFilterButton = onView(withId(R.id.menu_filter))

    private val clearCompletedMenuTile = onView(allOf(withId(R.id.title), withText(R.string.menu_clear)))
    private val refreshMenuTile = onView(allOf(withId(R.id.title), withText(R.string.refresh)))
    private val shareMenuTile = onView(allOf(withId(R.id.title), withText(R.string.share)))

    private val allFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_all)))
    private val activeFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_active)))
    private val completedFilterTile = onView(allOf(withId(R.id.title), withText(R.string.nav_completed)))
    private val tasksList = onView(withId(R.id.tasks_list))
    private val noTasksIcon = onView(withId(R.id.noTasks))

    private val snackbar = onView(withId(android.support.design.R.id.snackbar_text))

    fun selectClearCompletedFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        clearCompletedMenuTile.perform(click())
        checkIfTasksClearedSnackbarIsVisible()
        return this
    }

    fun selectRefreshFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        refreshMenuTile.perform(click())
        return this
    }

    fun selectShareFromContextualMenu(): TodoListScreen {
        openContextualActionModeOverflowMenu()
        shareMenuTile.perform(click())
        return this
        //TODO Temporary solution. In the future Implement system 'Share to' PO model to interact with system items
    }

    fun showAllTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        allFilterTile.perform(click())
        return this
    }

    fun showActiveTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        activeFilterTile.perform(click())
        return this
    }

    fun showCompletedTasks(): TodoListScreen {
        clickOnMenuFilterButton()
        completedFilterTile.perform(click())
        return this
    }

    fun clickOnFABButton(): AddEditTaskScreen {
        newTaskFabButton.perform(click())
        return AddEditTaskScreen()
    }

    fun clickOnMenuFilterButton(): TodoListScreen {
        menuFilterButton.perform(click())
        return this
    }

    fun checkIfTasksClearedSnackbarIsVisible(): TodoListScreen {
        snackbar.check(matches(isDisplayed()))
                .check(matches(withText(R.string.completed_tasks_cleared)))
        return this
    }

    fun checkIfToDoSavedSnackbarIsVisible(): TodoListScreen {
        snackbar.check(matches(isDisplayed()))
                .check(matches(withText(R.string.successfully_saved_task_message)))
        return this
    }

    fun checkIfTaskIsDisplayed(taskTitle: String): TodoListScreen {
        onView(withText(taskTitle)).check(matches(isDisplayed()))
        return this
    }

    fun checkIfTaskIsNotDisplayed(taskTitle: String): TodoListScreen {
        try {
            onView(withText(taskTitle)).check(matches(isDisplayed()))
            throw Exception("Task $taskTitle displays in list but is should not")
        } catch (e: NoMatchingViewException) {
            return this
        }
    }

    fun enterTaskDetails(taskName: String): TaskDetailsScreen {
        onView(allOf(withText(taskName), withParent(instanceOf(LinearLayout::class.java))))
                .perform(click())
        return TaskDetailsScreen()
    }

    fun markTaskAsCompleted(taskName: String): TodoListScreen {
        onView(allOf(instanceOf(CheckBox::class.java), hasSibling(withText(taskName))))
                .perform(click())
        return this
    }

    fun taskMarkedAsCompleteSnackbarIsVisible(): TodoListScreen {
        snackbar.check(matches(isDisplayed())).
        check(matches(withText(R.string.task_marked_complete)))
        return this
    }

    fun checkIfListIsEmpty(): TodoListScreen {
        noTasksIcon.check(matches(isDisplayed()))
        return this
    }

    fun waitForSnackbarDisappearing(): TodoListScreen {
        while (isSnackbarDisplayed()) {
            Thread.sleep(1000)
        }
        return this
    }

    fun isSnackbarDisplayed(): Boolean {
        return try {
            snackbar.check(matches(isDisplayed()))
            true
        } catch (e: Exception) {
            false
        }
    }
}