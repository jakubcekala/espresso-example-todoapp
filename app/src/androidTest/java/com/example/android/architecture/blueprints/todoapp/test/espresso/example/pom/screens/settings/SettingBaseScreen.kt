package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.SettingsScreen
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf

abstract class SettingBaseScreen {
    private val toolbarBackButton = Espresso.onView(AllOf.allOf(CoreMatchers.instanceOf(ImageButton::class.java),
            ViewMatchers.withParent(ViewMatchers.withId(R.id.toolbar))))

    fun clickOnBackToolbarButton(): SettingsScreen {
        toolbarBackButton.perform(ViewActions.click())
        return SettingsScreen()
    }
}