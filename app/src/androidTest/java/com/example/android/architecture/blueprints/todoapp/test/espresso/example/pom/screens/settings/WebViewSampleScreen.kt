package com.example.android.architecture.blueprints.todoapp.test.espresso.example.pom.screens.settings

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.android.architecture.blueprints.todoapp.R

class WebViewSampleScreen : SettingBaseScreen() {
    private val webView = onView(withId(R.id.web_view))
    //TODO Handle WebView components
}
