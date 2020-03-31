package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.android.architecture.blueprints.todoapp.R

class AddEditTaskScreen {
    private val taskTitleEditText = onView(withId(R.id.add_task_title))
    private val taskDescriptionEditText = onView(withId(R.id.add_task_description))
    private val confirmFabButton = onView(withId(R.id.fab_edit_task_done))

    fun enterTaskTitle(title: String) {
        taskTitleEditText.perform(typeText(title), closeSoftKeyboard())
    }

    fun enterTaskDescription(description: String) {
        taskDescriptionEditText.perform(typeText(description), closeSoftKeyboard())
    }

    fun updateTaskTitle(title: String) {
        taskTitleEditText.perform(clearText(), typeText(title), closeSoftKeyboard())
    }

    fun updateTaskDescription(description: String) {
        taskDescriptionEditText.perform(clearText(), typeText(description), closeSoftKeyboard())
    }

    fun clickOnConfirmFabButton(): TodoListScreen {
        confirmFabButton.perform(click())
        return TodoListScreen()
    }

    fun addNewTask(title: String, description: String): TodoListScreen {
        enterTaskTitle(title)
        enterTaskDescription(description)
        clickOnConfirmFabButton()
        return TodoListScreen()
    }

    fun updateTask(title: String, description: String): TodoListScreen {
        updateTaskTitle(title)
        updateTaskDescription(description)
        clickOnConfirmFabButton()
        return TodoListScreen()
    }
}
