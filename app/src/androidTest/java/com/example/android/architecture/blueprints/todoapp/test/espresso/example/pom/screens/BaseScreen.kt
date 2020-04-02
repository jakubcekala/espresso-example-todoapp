package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.core.AllOf.allOf

open class BaseScreen : ScreenObject() {

    private val hamburgerMenuButton = onView(allOf(instanceOf(ImageButton::class.java),
            withParent(withId(R.id.toolbar))))

    fun openHamburgerMenu(): HamburgerMenu {
        hamburgerMenuButton.perform(click())
        return HamburgerMenu()
    }
}