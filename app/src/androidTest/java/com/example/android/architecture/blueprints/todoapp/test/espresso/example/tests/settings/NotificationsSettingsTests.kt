package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.settings

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.NotificationSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.BaseTest
import org.junit.Before
import org.junit.Test

class NotificationsSettingsTests: BaseTest() {

    lateinit var notificationSettingsScreen: NotificationSettingsScreen

    @Before
    fun goToNotificationSettingScreen() {
        notificationSettingsScreen = TodoListScreen().openHamburgerMenu().
            clickOnSettingsButton().clickOnNotificationButton()
    }

    @Test
    fun sendNotification() {
        notificationSettingsScreen.clickOnSendNotificationButton()
    }

    @Test
    fun sendNotificationWithDelay() {
        notificationSettingsScreen.clickOnSendNotificationWIthDelayButton()
    }

    @Test
    fun enableNotifications() {
        notificationSettingsScreen.enableNotification().isEnableNotificationSubmenuDisplayed()
    }

    //TODO Create tests for ""Notify when TO-DO older than"
    //TODO Create tests for Ringtone settings

    @Test
    fun changeVibrateStatus() {
        notificationSettingsScreen.enableNotification().turnOnVibrate().turnOffVibrate()
    }
}