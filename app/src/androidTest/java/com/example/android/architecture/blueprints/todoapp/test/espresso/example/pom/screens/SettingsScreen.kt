package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.widget.ImageButton
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.DataSyncSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.GeneralSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.NotificationSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.WebViewSampleScreen
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.core.AllOf.allOf

class SettingsScreen {
    private val generalButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_general)))
    private val notificationsButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_notifications)))
    private val dataSyncButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_data_sync)))
    private val webViewSampleButton = onView(allOf(withId(R.id.title), withText(R.string.pref_header_webview_sample)))
    private val toolbarBackButton = onView(allOf(instanceOf(ImageButton::class.java),
            ViewMatchers.withParent(withId(R.id.toolbar))))

    fun clickOnGeneralButton(): GeneralSettingsScreen {
        generalButton.perform(click())
        return GeneralSettingsScreen()
    }

    fun clickOnNotificationButton(): NotificationSettingsScreen {
        notificationsButton.perform(click())
        return NotificationSettingsScreen()
    }

    fun clickOnDataSyncButton(): DataSyncSettingsScreen {
        dataSyncButton.perform(click())
        return DataSyncSettingsScreen()
    }

    fun clickOnWebViewSampleButton(): WebViewSampleScreen {
        webViewSampleButton.perform(click())
        return WebViewSampleScreen()
    }

    fun clickOnBackToolbarButtonToTodoListScreen(): TodoListScreen {
        toolbarBackButton.perform(click())
        return TodoListScreen()
    }

    fun clickOnBackToolbarButtonToStatisticScreen(): StatisticsScreen {
        toolbarBackButton.perform(click())
        return StatisticsScreen()
    }
}
