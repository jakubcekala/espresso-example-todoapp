package com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata

import java.util.*

class AddTasksTestData {
    companion object {
        fun getTaskItem(): TaskModel {
            return TaskModel("Title" + Random().nextInt(), "Description" + Random().nextInt())
        }
    }
}