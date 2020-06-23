package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.Matchers.allOf

class DataSyncSettingsScreen : SettingBaseScreen() {
    private val syncFrequencyButton = onView(allOf(withId(R.id.title), withText(R.string.pref_title_sync_frequency)))
    private val systemSyncSettingsButton = onView(allOf(withId(R.id.title), withText(R.string.pref_title_system_sync_settings)))

    fun clickOnSyncFrequencyButton(): SyncFrequencyDialog {
        syncFrequencyButton.perform(click())
        return SyncFrequencyDialog()
    }

    fun clickOnSyncSettingsButtons() {
        systemSyncSettingsButton.perform(click())
    }

    inner class SyncFrequencyDialog {
        fun selectSyncFrequency(freq: SyncFrequency): DataSyncSettingsScreen {
            onView(allOf(withId(android.R.id.text1), withText(freq.freq)))
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
