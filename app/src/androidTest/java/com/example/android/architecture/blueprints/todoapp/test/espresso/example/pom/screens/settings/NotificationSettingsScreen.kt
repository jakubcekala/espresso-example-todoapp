package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.CoreMatchers.allOf
import java.lang.Exception

open class NotificationSettingsScreen : SettingBaseScreen() {
    private val sendNotificationButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_send_notifications)))
    private val sendNotificationButtonWithDelayButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_send_notifications_with_delay)))
    private val enableNotificationButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_new_message_notifications)))
    private val enableNotificationSwitch = onView(allOf(withId(android.R.id.switch_widget), withParent(withId(android.R.id.widget_frame))))

    fun clickOnSendNotificationButton(): NotificationSettingsScreen {
        sendNotificationButton.perform(click())
        return this
    }

    fun clickOnSendNotificationWIthDelayButton(): NotificationSettingsScreen {
        sendNotificationButtonWithDelayButton.perform(click())
        return this
    }

    fun enableNotification(): EnableNotificationOnNotificationSettingsScreen {
        return if(isEnableNotificationSubmenuDisplayed()) {
            EnableNotificationOnNotificationSettingsScreen()
        } else {
            enableNotificationButton.perform(click())
            EnableNotificationOnNotificationSettingsScreen()
        }
    }

    fun disableNotification(): NotificationSettingsScreen {
        return if (isEnableNotificationSubmenuDisplayed()) {
            enableNotificationButton.perform(click())
            this
        } else {
            this
        }
    }

    fun isEnableNotificationSubmenuDisplayed(): Boolean {
        return try {
            onView(allOf(withId(android.R.id.title), withText(R.string.slider_title))).check(matches(isDisplayed()))
            onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_ringtone))).check(matches(isDisplayed()))
            onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_vibrate))).check(matches(isDisplayed()))
            true
        } catch (exception: Exception) {
            false
        }
    }

    class EnableNotificationOnNotificationSettingsScreen : NotificationSettingsScreen() {
        private val notifyWhenButton = onView(allOf(withId(android.R.id.title), withText(R.string.slider_title)))
        private val ringtoneButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_ringtone)))
        private val vibrateButton = onView(allOf(withId(android.R.id.title), withText(R.string.pref_title_vibrate)))
        private val vibrateCheckbox = onView(allOf(withId(android.R.id.checkbox), withParent(withId(android.R.id.widget_frame))))

        fun clickOnNotifyWhenButton(): NotificationOlderDialog {
            notifyWhenButton.perform(click())
            return NotificationOlderDialog()
        }

        fun clickOnRingtoneButton(): RingtoneDialog {
            ringtoneButton.perform(click())
            return RingtoneDialog()
        }

        fun turnOnVibrate(): EnableNotificationOnNotificationSettingsScreen {
            return if (isVibrateCheckboxChecked()) {
                this
            } else {
                vibrateButton.perform(click())
                this
            }
        }

        fun turnOffVibrate(): EnableNotificationOnNotificationSettingsScreen {
            return if (!isVibrateCheckboxChecked()) {
                this
            } else {
                vibrateButton.perform(click())
                this
            }
        }

        fun isVibrateCheckboxChecked(): Boolean {
            return try {
                vibrateCheckbox.check(matches(isChecked()))
                true
            } catch (exception: Exception) {
                false
            }
        }

        inner class NotificationOlderDialog {
            private val sliderSeekbar = onView(withId(R.id.slider_preference_seekbar))
            private val okButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
            private val cancelButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))

            fun clickOnOkButton(): EnableNotificationOnNotificationSettingsScreen {
                okButton.perform(click())
                return EnableNotificationOnNotificationSettingsScreen()
            }

            fun clickOnCancelButton(): EnableNotificationOnNotificationSettingsScreen {
                cancelButton.perform(click())
                return EnableNotificationOnNotificationSettingsScreen()
            }
        }

        inner class RingtoneDialog {
            private val okButton = onView(allOf(withId(android.R.id.button1), withText(android.R.string.ok)))
            private val cancelButton = onView(allOf(withId(android.R.id.button2), withText(android.R.string.cancel)))

            fun clickOnOkButton(): EnableNotificationOnNotificationSettingsScreen {
                okButton.perform(click())
                return EnableNotificationOnNotificationSettingsScreen()
            }

            fun clickOnCancelButton(): EnableNotificationOnNotificationSettingsScreen {
                cancelButton.perform(click())
                return EnableNotificationOnNotificationSettingsScreen()
            }
        }
    }
}