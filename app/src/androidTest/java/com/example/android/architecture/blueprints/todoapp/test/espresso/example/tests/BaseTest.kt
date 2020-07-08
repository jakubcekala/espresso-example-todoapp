package com.example.android.architecture.blueprints.todoapp.test.espresso.example.tests

import android.Manifest
import android.support.test.rule.ActivityTestRule
import android.support.test.rule.GrantPermissionRule
import android.support.test.runner.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity
import org.junit.Rule
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class BaseTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(TasksActivity::class.java)

    @get:Rule
    var ruleChain: RuleChain = RuleChain
            .outerRule(GrantPermissionRule.grant(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA))
}
