package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.RelativeLayout
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata.SettingsTestData
import org.hamcrest.CoreMatchers.instanceOf
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
        val emailLabel = onView(allOf(withText(email), withParent(instanceOf(RelativeLayout::class.java))))
        emailLabel.check(matches(isDisplayed()))
    }

    fun verifyTitleInSortByTile(sortType: SettingsTestData.SortType): GeneralSettingsScreen {
        val sortItemTile = onView(allOf(withText(sortType.text), withParent(instanceOf(RelativeLayout::class.java))))
        sortItemTile.check(matches(isDisplayed()))
        return this
    }

    inner class EmailToShareDialog {
        private val emailEditText = onView(withId(android.R.id.edit))
        private val okButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
        private val cancelButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))

        fun enterEmail(email: String): EmailToShareDialog {
            emailEditText.perform(typeText(email))
            return this
        }

        fun clearEmail(): EmailToShareDialog {
            emailEditText.perform(clearText())
            return this
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

    inner class SortByDialog {
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
