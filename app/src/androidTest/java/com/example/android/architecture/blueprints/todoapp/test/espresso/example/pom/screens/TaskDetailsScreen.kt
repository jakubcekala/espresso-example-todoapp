package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.CheckBox
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

class TaskDetailsScreen {

    private val deleteTaskButton = onView(withId(R.id.menu_delete))
    private val editFABButton = onView(withId(R.id.fab_edit_task))
    private val toolbarBackButton = onView(allOf(instanceOf(ImageButton::class.java),
            withParent(withId(R.id.toolbar))))
    private val snackbar = onView(withId(R.id.snackbar_text))

    fun clickOnDeleteTaskButton(): TodoListScreen {
        deleteTaskButton.perform(click())
        return TodoListScreen()
    }

    fun clickOnEditFABButton(): AddEditTaskScreen {
        editFABButton.perform(click())
        return AddEditTaskScreen()
    }

    fun clickOnBakButton(): TodoListScreen {
        toolbarBackButton.perform(click())
        return TodoListScreen()
    }

    fun markTaskAsCompleted(taskName: String): TaskDetailsScreen {
        onView(allOf(instanceOf(CheckBox::class.java), hasSibling(withText(taskName))))
                .perform(click())
        return TaskDetailsScreen()
    }

    fun taskMarkedAsCompleteSnackbarIsVisible(): TaskDetailsScreen {
        snackbar.check(matches(isDisplayed())).
                check(matches(withText(R.string.task_marked_complete)))
        return TaskDetailsScreen()
    }
}