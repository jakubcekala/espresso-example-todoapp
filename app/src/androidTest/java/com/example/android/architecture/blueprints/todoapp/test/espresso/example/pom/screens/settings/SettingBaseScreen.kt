package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withParent
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.SettingsScreen
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf

abstract class SettingBaseScreen {
    private val toolbarBackButton = onView(allOf(instanceOf(ImageButton::class.java),
            withParent(withId(R.id.toolbar))))

    fun clickOnBackToolbarButton(): SettingsScreen {
        toolbarBackButton.perform(click())
        return SettingsScreen()
    }
}