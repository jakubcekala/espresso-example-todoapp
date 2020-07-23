package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.settings

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.GeneralSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.SettingsTestData
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests.BaseTest
import org.junit.Before
import org.junit.Test

class GeneralSettingsTests: BaseTest() {

    lateinit var generalSettingsScreen: GeneralSettingsScreen

    @Before
    fun goToGeneralSettingScreen() {
        generalSettingsScreen = TodoListScreen()
                .openHamburgerMenu()
                .clickOnSettingsButton()
                .clickOnGeneralButton()
    }

    @Test
    fun changeEmailToShare() {
        generalSettingsScreen
                .clickOnEmailToShareButton()
                .clearEmail()
                .enterEmail(SettingsTestData.email)
                .clickOnOkButton()
                .verifyEmailInEmailToShareTile(SettingsTestData.email)
    }

    @Test
    fun sortByCreationDate() {
        generalSettingsScreen
                .clickOnSortByButton()
                .selectCreationDate()
                .verifyTitleInSortByTile(SettingsTestData.SortType.CREATION_DATE)
    }

    @Test
    fun sortByUpdateDate() {
        generalSettingsScreen
                .clickOnSortByButton()
                .selectUpdateDate()
                .verifyTitleInSortByTile(SettingsTestData.SortType.UPDATE_DATE)
    }

    @Test
    fun sortByTitle() {
        generalSettingsScreen
                .clickOnSortByButton()
                .selectTitle()
                .verifyTitleInSortByTile(SettingsTestData.SortType.TITLE)
    }
}