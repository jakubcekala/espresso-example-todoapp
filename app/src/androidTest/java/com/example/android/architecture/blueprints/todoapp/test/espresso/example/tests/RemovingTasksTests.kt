package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import org.junit.Before
import org.junit.Test
import java.util.*

class RemovingTasksTests: BaseTest() {

    private lateinit var todoListScreen: TodoListScreen

    var taskTitle = ""
    var taskDescription = ""

    @Before
    fun setTaskDetails() {
        taskTitle = "Title" + Random().nextInt()
        taskDescription = "Description" + Random().nextInt()
    }

    @Before
    fun createTaskToRemove() {
        todoListScreen = TodoListScreen().clickOnFABButton().addNewTask(taskTitle, taskDescription)
    }

    @Test
    fun removeActiveTask() {
        todoListScreen.enterTaskDetails(taskTitle).clickOnDeleteTaskButton().checkIfListIsEmpty()
    }

    @Test
    fun removeCompletedTask() {
        todoListScreen.markTaskAsCompleted(taskTitle).enterTaskDetails(taskTitle)
                .clickOnDeleteTaskButton().checkIfListIsEmpty()
    }

    @Test
    fun clearCompletedTasks() {
        todoListScreen.markTaskAsCompleted(taskTitle).selectClearCompletedFromContextualMenu().
                checkIfListIsEmpty()
    }
}