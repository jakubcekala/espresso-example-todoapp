package com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata

class SettingsTestData {
    enum class SyncFrequency(val freq: String) {
        MINUTES15("15 minutes"),
        MINUTES30("30 minutes"),
        HOUR("1 hour"),
        HOURS3("3 hours"),
        HOURS6("6 hours"),
        NEVER("Never")
    }
}