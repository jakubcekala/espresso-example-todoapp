package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TaskModel
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.TasksTestData
import org.junit.Before
import org.junit.Test

class RemovingTasksTests: BaseTest() {

    private lateinit var todoListScreen: TodoListScreen
    private lateinit var taskItem: TaskModel

    @Before
    fun setTaskDetails() {
        taskItem = TasksTestData.getTaskItem()
    }

    @Before
    fun createTaskToRemove() {
        todoListScreen = TodoListScreen()
                .clickOnFABButton()
                .addNewTask(taskItem.title, taskItem.description)
    }

    @Test
    fun removeActiveTask() {
        todoListScreen
                .enterTaskDetails(taskItem.title)
                .clickOnDeleteTaskButton()
                .checkIfListIsEmpty()
    }

    @Test
    fun removeCompletedTask() {
        todoListScreen
                .markTaskAsCompleted(taskItem.title)
                .enterTaskDetails(taskItem.title)
                .clickOnDeleteTaskButton()
                .checkIfListIsEmpty()
    }

    @Test
    fun clearCompletedTasks() {
        todoListScreen
                .markTaskAsCompleted(taskItem.title)
                .selectClearCompletedFromContextualMenu()
                .checkIfListIsEmpty()
    }
}