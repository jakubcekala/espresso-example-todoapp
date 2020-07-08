package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.AddEditTaskScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import org.junit.Before
import org.junit.Test
import java.util.*

class EditTasksTests: BaseTest() {

    private lateinit var editTaskScreen: AddEditTaskScreen

    private var taskTitle = ""
    private var taskDescription = ""
    private var taskTitleEdited = ""
    private var taskDescriptionEdited = ""

    @Before
    fun setTaskDetails() {
        taskTitle = "Title" + Random().nextInt()
        taskDescription = "Description" + Random().nextInt()
        taskTitleEdited = "Title" + Random().nextInt()
        taskDescriptionEdited = "Description" + Random().nextInt()
    }

    @Before
    fun addTaskToEdit() {
        editTaskScreen = TodoListScreen().clickOnFABButton().
                addNewTask(taskTitle, taskDescription).
                enterTaskDetails(taskTitle).clickOnEditFABButton()
    }

    @Test
    fun editTaskCorrectly() {
        editTaskScreen.updateTask(taskTitleEdited, taskDescriptionEdited).
                checkIfTaskIsDisplayed(taskTitleEdited)
    }

    @Test
    fun editTaskEmptyTitle() {
        editTaskScreen.updateTask("", taskDescriptionEdited).
                checkIfTaskIsDisplayed(taskDescriptionEdited)
    }

    @Test
    fun editTaskEmptyDescription() {
        editTaskScreen.updateTask(taskTitleEdited,"").
                checkIfTaskIsDisplayed(taskTitleEdited)
    }

    @Test
    fun editTaskEmptyTitleAndDescription() {
        editTaskScreen.updateTaskTitle("").updateTaskDescription("").
                clickOnConfirmFabButton().
                checkErrorSnackbarIsDisplayed().checkIfTitleErrorIsDisplayed()
    }
}