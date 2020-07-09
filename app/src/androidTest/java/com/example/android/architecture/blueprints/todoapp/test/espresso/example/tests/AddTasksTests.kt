package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TaskModel
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TasksTestData
import org.junit.Before
import org.junit.Test

class AddTasksTests: BaseTest() {

    lateinit var taskItem: TaskModel

    @Before
    fun setTaskDetails() {
        taskItem = TasksTestData.getTaskItem()
    }

    @Test
    fun addCorrectTask() {
        TodoListScreen()
                .clickOnFABButton()
                .addNewTask(taskItem.title, taskItem.description)
                .checkIfToDoSavedSnackbarIsVisible()
                .checkIfTaskIsDisplayed(taskItem.title)
    }

    @Test
    fun addEmptyTask() {
        TodoListScreen()
                .clickOnFABButton()
                .clickOnConfirmFabButton()
                .checkIfTitleErrorIsDisplayed()
                .checkErrorSnackbarIsDisplayed()
    }

    @Test
    fun addTaskWithOnlyTitle() {
        TodoListScreen()
                .clickOnFABButton()
                .addNewTask(taskItem.title, taskItem.description)
                .checkIfToDoSavedSnackbarIsVisible()
                .checkIfTaskIsDisplayed(taskItem.title)
    }

    @Test
    fun addTaskWithOnlyDescription() {
        TodoListScreen()
                .clickOnFABButton()
                .addNewTask("", taskItem.description).
                checkIfToDoSavedSnackbarIsVisible()
                .checkIfTaskIsDisplayed(taskItem.description)
    }
}