package com.example.android.architecture.blueprints.todoapp.test.espresso.example.testdata

class SettingsTestData {

    //DataSyncSettingsTests
    enum class SyncFrequency(val freq: String) {
        MINUTES15("15 minutes"),
        MINUTES30("30 minutes"),
        HOUR("1 hour"),
        HOURS3("3 hours"),
        HOURS6("6 hours"),
        NEVER("Never")
    }

    //GeneralSettingsTests
    enum class SortType(val text: String) {
        CREATION_DATE("Creation date"),
        UPDATE_DATE("Update date"),
        TITLE("Title")
    }

    companion object{
        //GeneralSettingsTests
        val email = "test@test.com"
    }
}