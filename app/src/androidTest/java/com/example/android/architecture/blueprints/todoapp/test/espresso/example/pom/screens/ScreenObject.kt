package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers

abstract class ScreenObject {
    /**
     * Methods below are to sleep Thread for specific length of time:
     * Short - 1s
     * Mid - 2s
     * Long - 5s
     */
    fun waitShort() {
        Thread.sleep(SHORT_SLEEP_TIME_MS)
    }

    fun waitMid() {
        Thread.sleep(MID_SLEEP_TIME_MS)
    }

    fun waitLong() {
        Thread.sleep(LONG_SLEEP_TIME_MS)
    }

    fun pressBack() {
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }

    companion object {
        private const val SHORT_SLEEP_TIME_MS = 500L
        private const val MID_SLEEP_TIME_MS = 2000L
        private const val LONG_SLEEP_TIME_MS = 5000L
    }
}