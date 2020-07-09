package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.RelativeLayout
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers.allOf

class DataSyncSettingsScreen : SettingBaseScreen() {
    private val syncFrequencyButton = onView( withText(R.string.pref_title_sync_frequency))
    private val systemSyncSettingsButton = onView( withText(R.string.pref_title_system_sync_settings))

    fun clickOnSyncFrequencyButton(): SyncFrequencyDialog {
        syncFrequencyButton.perform(click())
        return SyncFrequencyDialog()
    }

    fun clickOnSyncSettingsButtons() {
        systemSyncSettingsButton.perform(click())
    }

    fun verifySetFrequency(selectedFreq: SyncFrequency): DataSyncSettingsScreen {
        val sortItemTile = onView(allOf(withText(selectedFreq.freq), withParent(CoreMatchers.instanceOf(RelativeLayout::class.java))))
        sortItemTile.check(matches(isDisplayed()))
        return this
    }

    inner class SyncFrequencyDialog {
        fun selectSyncFrequency(freq: SyncFrequency): DataSyncSettingsScreen {
            onView(allOf(withId(android.R.id.text1), withText(freq.freq))).perform(click())
            return DataSyncSettingsScreen()
        }
    }

    enum class SyncFrequency(val freq: String) {
        MINUTES15("15 minutes"),
        MINUTES30("30 minutes"),
        HOUR("1 hour"),
        HOURS3("3 hours"),
        HOURS6("6 hours"),
        NEVER("Never")
    }
}
