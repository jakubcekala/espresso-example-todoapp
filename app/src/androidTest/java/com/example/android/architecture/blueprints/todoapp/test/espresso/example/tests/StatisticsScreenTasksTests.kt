package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import android.support.test.InstrumentationRegistry
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TaskModel
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TasksTestData
import org.junit.Before
import org.junit.Test

class StatisticsScreenTasksTests: BaseTest() {

    private lateinit var tasksScreenWithCreatedTasks: TodoListScreen
    private lateinit var taskItem1: TaskModel
    private lateinit var taskItem2: TaskModel

    @Before
    fun setTasksData() {
        taskItem1 = TasksTestData.getTaskItem()
        taskItem2 = TasksTestData.getTaskItem()
    }

    @Before
    fun createTwoTasks() {
        tasksScreenWithCreatedTasks = TodoListScreen()
                .clickOnFABButton()
                .addNewTask(taskItem1.title, taskItem2.description)
                .waitForSnackbarDisappearing()
                .clickOnFABButton()
                .addNewTask(taskItem2.title, taskItem2.description)
                .waitForSnackbarDisappearing()
    }

    @Before
    fun resetAppData() {
        InstrumentationRegistry.getTargetContext().deleteDatabase("Tasks.db")
    }

    @Test
    fun statisticScreenTasksBothCategoryNotEmpty() {
        val activeTasks = 1
        val completedTasks = 1

        tasksScreenWithCreatedTasks
                .markTaskAsCompleted(taskItem1.title)
                .openHamburgerMenu()
                .clickOnStatisticsButton()
                .clickOkAlertDialog()
                .verifyNotEmptyStatisticScreen(activeTasks, completedTasks)
    }

    @Test
    fun statisticScreenTasksActiveEmpty() {
        val activeTasks = 0
        val completedTasks = 2

        tasksScreenWithCreatedTasks
                .markTaskAsCompleted(taskItem1.title)
                .markTaskAsCompleted(taskItem2.title)
                .openHamburgerMenu()
                .clickOnStatisticsButton()
                .clickOkAlertDialog()
                .verifyNotEmptyStatisticScreen(activeTasks, completedTasks)
    }

    @Test
    fun statisticScreenTasksCompleatedEmpty() {
        val activeTasks = 2
        val completedTasks = 0

        tasksScreenWithCreatedTasks
                .openHamburgerMenu()
                .clickOnStatisticsButton()
                .clickOkAlertDialog()
                .verifyNotEmptyStatisticScreen(activeTasks, completedTasks)
    }
}