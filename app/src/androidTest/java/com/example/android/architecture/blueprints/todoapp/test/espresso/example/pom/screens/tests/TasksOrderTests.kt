package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import org.junit.Before
import org.junit.Test
import java.util.*

class TasksOrderTests: BaseTest() {

    lateinit var todoListScreen: TodoListScreen

    private var taskTitle1 = ""
    private var taskTitle2 = ""
    private var taskDesc1 = ""
    private var taskDesc2 = ""

    @Before
    fun setTasksData() {
        taskTitle1 = "Title1" + Random().nextInt()
        taskTitle2 = "Title2" + Random().nextInt()
        taskDesc1 = "Description1" + Random().nextInt()
        taskDesc2 = "Description2" + Random().nextInt()
    }

    @Before
    fun createTwoTasks() {
        todoListScreen = TodoListScreen().clickOnFABButton().addNewTask(taskTitle1, taskDesc1).
                waitForSnackbarDisappearing().
                clickOnFABButton().addNewTask(taskTitle2, taskDesc2)
    }

    @Test
    fun activeTasksFilter() {
        todoListScreen.markTaskAsCompleted(taskTitle1).showActiveTasks().
                checkIfTaskIsDisplayed(taskTitle2).checkIfTaskIsNotDisplayed(taskTitle1)
    }

    @Test
    fun completedTaskFilter() {
        todoListScreen.markTaskAsCompleted(taskTitle1).showCompletedTasks().
                checkIfTaskIsDisplayed(taskTitle1).checkIfTaskIsNotDisplayed(taskTitle2)
    }

    @Test
    fun allTasksFilter() {
        todoListScreen.markTaskAsCompleted(taskTitle1).showAllTasks().
                checkIfTaskIsDisplayed(taskTitle1).checkIfTaskIsDisplayed(taskTitle2).
                markTaskAsCompleted(taskTitle2).
                checkIfTaskIsDisplayed(taskTitle1).checkIfTaskIsDisplayed(taskTitle2)
    }
}