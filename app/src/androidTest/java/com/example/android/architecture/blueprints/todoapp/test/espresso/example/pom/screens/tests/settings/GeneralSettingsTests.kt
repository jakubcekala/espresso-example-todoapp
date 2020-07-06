package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.tests.settings

import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.TodoListScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings.GeneralSettingsScreen
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.tests.BaseTest
import org.junit.Before
import org.junit.Test

class GeneralSettingsTests: BaseTest() {

    lateinit var generalSettingsScreen: GeneralSettingsScreen

    val email = "test@test.com"

    @Before
    fun goToGeneralSettingScreen() {
        generalSettingsScreen = TodoListScreen().openHamburgerMenu().
                                        clickOnSettingsButton().clickOnGeneralButton()
    }

    @Test
    fun changeEmailToShare() {
        generalSettingsScreen.clickOnEmailToShareButton().
            clearEmail().enterEmail(email).clickOnOkButton().
                verifyEmailInEmailToShareTile(email)
    }

    @Test
    fun sortByCreationDate() {
        generalSettingsScreen.clickOnSortByButton().selectCreationDate()
                .verifyTitleInSortByTile(GeneralSettingsScreen.SortType.CREATION_DATE)
    }

    @Test
    fun sortByUpdateDate() {
        generalSettingsScreen.clickOnSortByButton().selectUpdateDate().
                verifyTitleInSortByTile(GeneralSettingsScreen.SortType.UPDATE_DATE)
    }

    @Test
    fun sortByTitle() {
        generalSettingsScreen.clickOnSortByButton().selectTitle().
            verifyTitleInSortByTile(GeneralSettingsScreen.SortType.TITLE)
    }
}