package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import org.junit.Before
import org.junit.Test
import java.util.*

class AddTasksTests: BaseTest() {

    var taskTitle = ""
    var taskDescription = ""

    @Before
    fun setTaskDetails() {
        taskTitle = "Title" + Random().nextInt()
        taskDescription = "Description" + Random().nextInt()
    }

    @Test
    fun addCorrectTask() {
        TodoListScreen().clickOnFABButton().addNewTask(taskTitle, taskDescription).
                checkIfToDoSavedSnackbarIsVisible().checkIfTaskIsDisplayed(taskTitle)
    }

    @Test
    fun addEmptyTask() {
        TodoListScreen().clickOnFABButton().clickOnConfirmFabButton().
                checkIfTitleErrorIsDisplayed().checkErrorSnackbarIsDisplayed()
    }

    @Test
    fun addTaskWithOnlyTitle() {
        TodoListScreen().clickOnFABButton().addNewTask(taskTitle, "").
                checkIfToDoSavedSnackbarIsVisible().checkIfTaskIsDisplayed(taskTitle)
    }

    @Test
    fun addTaskWithOnlyDescription() {
        TodoListScreen().clickOnFABButton().addNewTask("", taskDescription).
                checkIfToDoSavedSnackbarIsVisible().checkIfTaskIsDisplayed(taskDescription)
    }
}