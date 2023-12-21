package com.github.fernandospr.appiumappexample.compose

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag

fun Modifier.testTagWithPackage(tag: String) =
    composed { testTag("${LocalContext.current.applicationContext.packageName}:id/$tag") }