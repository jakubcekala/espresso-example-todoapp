package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.chapter3.click
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.DataSyncSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.GeneralSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.NotificationSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.WebViewSampleScreen
import org.hamcrest.CoreMatchers.allOf

class SettingsScreen {
    private val generalButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_general)))
    private val notificationsButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_notifications)))
    private val dataSyncButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_data_sync)))
    private val webViewSampleButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_webview_sample)))

    fun clickOnGeneralButton(): GeneralSettingsScreen {
        generalButton.click()
        return GeneralSettingsScreen()
    }

    fun clickOnNotificationButton(): NotificationSettingsScreen {
        notificationsButton.click()
        return NotificationSettingsScreen()
    }

    fun clickOnDataSyncButton(): DataSyncSettingsScreen {
        dataSyncButton.click()
        return DataSyncSettingsScreen()
    }

    fun clickOnWebViewSampleButton(): WebViewSampleScreen {
        webViewSampleButton.click()
        return WebViewSampleScreen()
    }
}
