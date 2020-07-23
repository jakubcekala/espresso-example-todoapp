package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.AddEditTaskScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TaskModel
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TasksTestData
import org.junit.Before
import org.junit.Test

class EditTasksTests: BaseTest() {

    private lateinit var editTaskScreen: AddEditTaskScreen

    private lateinit var taskItem: TaskModel
    private lateinit var taskItemEdited: TaskModel

    @Before
    fun setTaskDetails() {
        taskItem = TasksTestData.getTaskItem()
        taskItemEdited = TasksTestData.getTaskItem()
    }

    @Before
    fun addTaskToEdit() {
        editTaskScreen = TodoListScreen()
                .clickOnFABButton()
                .addNewTask(taskItem.title, taskItem.description)
                .enterTaskDetails(taskItem.title)
                .clickOnEditFABButton()
    }

    @Test
    fun editTaskCorrectly() {
        editTaskScreen
                .updateTask(taskItemEdited.title, taskItemEdited.description)
                .checkIfTaskIsDisplayed(taskItemEdited.title)
    }

    @Test
    fun editTaskEmptyTitle() {
        editTaskScreen
                .updateTask("", taskItemEdited.description)
                .checkIfTaskIsDisplayed(taskItemEdited.description)
    }

    @Test
    fun editTaskEmptyDescription() {
        editTaskScreen
                .updateTask(taskItemEdited.title,"")
                .checkIfTaskIsDisplayed(taskItemEdited.title)
    }

    @Test
    fun editTaskEmptyTitleAndDescription() {
        editTaskScreen
                .updateTaskTitle("")
                .updateTaskDescription("")
                .clickOnConfirmFabButton()
                .checkErrorSnackbarIsDisplayed()
                .checkIfTitleErrorIsDisplayed()
    }
}