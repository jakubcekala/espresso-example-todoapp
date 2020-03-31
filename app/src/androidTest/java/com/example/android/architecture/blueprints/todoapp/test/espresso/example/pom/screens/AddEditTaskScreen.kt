package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.chapter3.click
import com.example.android.architecture.blueprints.todoapp.test.chapter3.closeKeyboard
import com.example.android.architecture.blueprints.todoapp.test.chapter3.type

class AddEditTaskScreen {
    private val taskTitleEditText = onView(withId(R.id.add_task_title))
    private val taskDescriptionEditText = onView(withId(R.id.add_task_description))
    private val confirmFabButton = onView(withId(R.id.fab_edit_task_done))

    fun enterTaskTitle(title: String) {
        taskTitleEditText.type(title).closeKeyboard()
    }

    fun enterTaskDescription(description: String) {
        taskDescriptionEditText.type(description).closeKeyboard()
    }

    fun updateTaskTitle(title: String) {
        taskTitleEditText.perform(clearText()).type(title).closeKeyboard()
    }

    fun updateTaskDescription(description: String) {
        taskDescriptionEditText.perform(clearText()).type(description).closeKeyboard()
    }

    fun clickOnConfirmFabButton(): TodoListScreen {
        confirmFabButton.click()
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
