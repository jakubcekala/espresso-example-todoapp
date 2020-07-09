package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf

class AddEditTaskScreen {
    private val taskTitleEditText = onView(withId(R.id.add_task_title))
    private val taskDescriptionEditText = onView(withId(R.id.add_task_description))
    private val confirmFabButton = onView(withId(R.id.fab_edit_task_done))
    private val toolbarBackButton = onView(AllOf.allOf(CoreMatchers.instanceOf(ImageButton::class.java),
            withParent(withId(R.id.toolbar))))
    private val snackbar = onView(withId(android.support.design.R.id.snackbar_text))

    fun enterTaskTitle(title: String): AddEditTaskScreen {
        taskTitleEditText.perform(typeText(title), closeSoftKeyboard())
        return this
    }

    fun enterTaskDescription(description: String): AddEditTaskScreen {
        taskDescriptionEditText.perform(typeText(description), closeSoftKeyboard())
        return this
    }

    fun updateTaskTitle(title: String): AddEditTaskScreen {
        taskTitleEditText.perform(clearText(), typeText(title), closeSoftKeyboard())
        return this
    }

    fun updateTaskDescription(description: String): AddEditTaskScreen {
        taskDescriptionEditText.perform(clearText(), typeText(description), closeSoftKeyboard())
        return this
    }

    fun clickOnConfirmFabButton(): AddEditTaskScreen {
        confirmFabButton.perform(click())
        return this
    }

    fun addNewTask(title: String, description: String): TodoListScreen {
        enterTaskTitle(title).
        enterTaskDescription(description).
        clickOnConfirmFabButton()
        return TodoListScreen()
    }

    fun updateTask(title: String, description: String): TodoListScreen {
        updateTaskTitle(title).
        updateTaskDescription(description).
        clickOnConfirmFabButton()
        return TodoListScreen()
    }

    fun clickOnBackToolbarButton(): TodoListScreen {
        toolbarBackButton.perform(click())
        return TodoListScreen()
    }

    fun checkIfTitleErrorIsDisplayed(): AddEditTaskScreen {
        taskTitleEditText.check(matches(hasErrorText(
                InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getString(R.string.add_task_empty_title))))
        return this
    }

    fun checkErrorSnackbarIsDisplayed(): AddEditTaskScreen {
        snackbar.check(matches(isDisplayed()))
                .check(matches(withText(R.string.empty_task_message)))
        return this
    }
}
