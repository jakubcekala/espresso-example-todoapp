package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.settings

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.DataSyncSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.BaseTest
import org.junit.Before
import org.junit.Test

class DataSyncSettingsTests: BaseTest() {

    lateinit var dataSyncSettingsScreen: DataSyncSettingsScreen

    @Before
    fun goToDataSyncSettingScreen() {
        dataSyncSettingsScreen = TodoListScreen().openHamburgerMenu().
            clickOnSettingsButton().clickOnDataSyncButton()
    }

    @Test
    fun set15MinutesFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.MINUTES15).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.MINUTES15)
    }

    @Test
    fun set30MinutesFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.MINUTES30).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.MINUTES30)
    }

    @Test
    fun set1HourFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.HOUR).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.HOUR)
    }

    @Test
    fun set3HoursFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.HOURS3).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.HOURS3)
    }

    @Test
    fun set6HoursFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.HOURS6).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.HOURS6)
    }

    @Test
    fun setNeverFreq() {
        dataSyncSettingsScreen.clickOnSyncFrequencyButton().
            selectSyncFrequency(DataSyncSettingsScreen.SyncFrequency.NEVER).
                verifySetFrequency(DataSyncSettingsScreen.SyncFrequency.NEVER)
    }
}