package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.settings

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.DataSyncSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.SettingsTestData
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.BaseTest
import org.junit.Before
import org.junit.Test

class DataSyncSettingsTests: BaseTest() {

    lateinit var dataSyncSettingsScreen: DataSyncSettingsScreen

    @Before
    fun goToDataSyncSettingScreen() {
        dataSyncSettingsScreen = TodoListScreen()
                .openHamburgerMenu()
                .clickOnSettingsButton()
                .clickOnDataSyncButton()
    }

    @Test
    fun set15MinutesFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.MINUTES15)
                .verifySetFrequency(SettingsTestData.SyncFrequency.MINUTES15)
    }

    @Test
    fun set30MinutesFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.MINUTES30)
                .verifySetFrequency(SettingsTestData.SyncFrequency.MINUTES30)
    }

    @Test
    fun set1HourFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.HOUR)
                .verifySetFrequency(SettingsTestData.SyncFrequency.HOUR)
    }

    @Test
    fun set3HoursFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.HOURS3)
                .verifySetFrequency(SettingsTestData.SyncFrequency.HOURS3)
    }

    @Test
    fun set6HoursFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.HOURS6)
                .verifySetFrequency(SettingsTestData.SyncFrequency.HOURS6)
    }

    @Test
    fun setNeverFreq() {
        dataSyncSettingsScreen
                .clickOnSyncFrequencyButton()
                .selectSyncFrequency(SettingsTestData.SyncFrequency.NEVER)
                .verifySetFrequency(SettingsTestData.SyncFrequency.NEVER)
    }
}