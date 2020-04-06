package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.RelativeLayout
import com.example.android.architecture.blueprints.todoapp.R
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

    fun verifyTitleInSortByTile(sortType: SortType) {
        val sortItemTile = onView(allOf(withText(sortType.text), withParent(instanceOf(RelativeLayout::class.java))))
        sortItemTile.check(matches(isDisplayed()))
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
        private val creationDateTile = onView(allOf(withId(android.R.id.text1), withText(SortType.CREATION_DATE.text)))
        private val updateDateTile = onView(allOf(withId(android.R.id.text1), withText(SortType.UPDATE_DATE.text)))
        private val titleTile = onView(allOf(withId(android.R.id.text1), withText(SortType.TITLE.text)))

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

    enum class SortType(val text: String) {
        CREATION_DATE("Creation date"),
        UPDATE_DATE("Update date"),
        TITLE("Title")
    }
}
