package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;

import static android.support.test.espresso.Espresso.onView;

abstract class PageObject {
    private static long SHORT_SLEEP_TIME_MS = 500L;
    private static long MID_SLEEP_TIME_MS = 2000L;
    private static long LONG_SLEEP_TIME_MS = 5000L;

    /**
     * Methods below are to sleep Thread for specific length of time:
     * Short - 1s
     * Mid - 2s
     * Long - 5s
     */
    void waitShort() throws InterruptedException {
        Thread.sleep(SHORT_SLEEP_TIME_MS);
    }

    void waitMid() throws InterruptedException {
        Thread.sleep(MID_SLEEP_TIME_MS);
    }

    void waitLong() throws InterruptedException {
        Thread.sleep(LONG_SLEEP_TIME_MS);
    }

    void pressBack() {
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
    }
}