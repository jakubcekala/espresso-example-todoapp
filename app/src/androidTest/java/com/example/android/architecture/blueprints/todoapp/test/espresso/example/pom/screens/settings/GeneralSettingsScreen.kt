package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.core.AllOf.allOf

class GeneralSettingsScreen : SettingBaseScreen() {

    private val emailToShareButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_email)))
    private val sortByButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_todos_sorting)))

    fun clickOnEmailToShareButton(): EmailToShareDialog {
        emailToShareButton.perform(click())
        return EmailToShareDialog()
    }

    fun clickOnSortByButton(): SortByDialog {
        sortByButton.perform(click())
        return SortByDialog()
    }

    fun verifyEmailInEmailToShareTile(email: String) {
        //TODO get text form label and compare to predicted one
    }

    fun verifyTitleInSortByTile() {
        //TODO get text form label and compare to predicted one
    }

    inner class SortByDialog {
        private val emailEditText = onView(withId(android.R.id.edit))
        private val okButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
        private val cancelButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))

        fun enterEmail(email: String) {
            emailEditText.perform(typeText(email))
        }

        fun clickOnOkButton(): GeneralSettingsScreen {
            okButton.perform(click())
            return GeneralSettingsScreen()
        }

        fun clickOnCancelButton():GeneralSettingsScreen {
            cancelButton.perform(click())
            return GeneralSettingsScreen()
        }
    }

    inner class EmailToShareDialog {
        private val creationDateTile = onView(allOf(withId(android.R.id.text1), withText("Creation date")))
        private val updateDateTile = onView(allOf(withId(android.R.id.text1), withText("Update date")))
        private val titleTile = onView(allOf(withId(android.R.id.text1), withText("Title")))

        fun selectCreationDate(): GeneralSettingsScreen {
            creationDateTile.perform(click())
            return GeneralSettingsScreen()
        }

        fun selectUpdateDate(): GeneralSettingsScreen {
            updateDateTile.perform(click())
            return GeneralSettingsScreen()
        }
        fun selectTitle(): GeneralSettingsScreen {
            titleTile.perform(click())
            return GeneralSettingsScreen()
        }
    }
}
