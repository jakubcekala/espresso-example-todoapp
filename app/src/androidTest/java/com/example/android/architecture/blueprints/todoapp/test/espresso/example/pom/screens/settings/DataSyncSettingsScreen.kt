package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.RelativeLayout
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.SettingsTestData
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

    fun verifySetFrequency(selectedFreq: SettingsTestData.SyncFrequency): DataSyncSettingsScreen {
        val sortItemTile = onView(allOf(withText(selectedFreq.freq), withParent(CoreMatchers.instanceOf(RelativeLayout::class.java))))
        sortItemTile.check(matches(isDisplayed()))
        return this
    }

    inner class SyncFrequencyDialog {
        fun selectSyncFrequency(freq: SettingsTestData.SyncFrequency): DataSyncSettingsScreen {
            onView(allOf(withId(android.R.id.text1), withText(freq.freq))).perform(click())
            return DataSyncSettingsScreen()
        }
    }
}
