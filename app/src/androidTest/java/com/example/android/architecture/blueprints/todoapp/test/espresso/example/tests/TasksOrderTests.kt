package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TaskModel
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TasksTestData
import org.junit.Before
import org.junit.Test
import java.util.*

class TasksOrderTests: BaseTest() {

    lateinit var todoListScreen: TodoListScreen
    lateinit var taskItem1: TaskModel
    lateinit var taskItem2: TaskModel

    @Before
    fun setTasksData() {
        taskItem1 = TasksTestData.getTaskItem()
        taskItem2 = TasksTestData.getTaskItem()
    }

    @Before
    fun createTwoTasks() {
        todoListScreen = TodoListScreen().clickOnFABButton().addNewTask(taskItem1.title, taskItem1.description).
                waitForSnackbarDisappearing().
                clickOnFABButton().addNewTask(taskItem2.title, taskItem2.description)
    }

    @Test
    fun activeTasksFilter() {
        todoListScreen.markTaskAsCompleted(taskItem1.title).showActiveTasks().
                checkIfTaskIsDisplayed(taskItem2.title).checkIfTaskIsNotDisplayed(taskItem1.title)
    }

    @Test
    fun completedTaskFilter() {
        todoListScreen.markTaskAsCompleted(taskItem1.title).showCompletedTasks().
                checkIfTaskIsDisplayed(taskItem1.title).checkIfTaskIsNotDisplayed(taskItem2.title)
    }

    @Test
    fun allTasksFilter() {
        todoListScreen.markTaskAsCompleted(taskItem1.title).showAllTasks().
                checkIfTaskIsDisplayed(taskItem1.title).checkIfTaskIsDisplayed(taskItem2.title).
                markTaskAsCompleted(taskItem2.title).
                checkIfTaskIsDisplayed(taskItem1.title).checkIfTaskIsDisplayed(taskItem2.title)
    }
}