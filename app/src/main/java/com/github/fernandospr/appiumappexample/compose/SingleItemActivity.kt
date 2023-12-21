package com.github.fernandospr.appiumappexample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.fernandospr.appiumappexample.models.Item
import com.github.fernandospr.appiumappexample.ui.theme.AppiumAppExampleTheme

class SingleItemActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppiumAppExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var item: Item by remember { mutableStateOf(Item(1, "Item 1")) }

                    ItemContainer(
                        item = item,
                        onSetClick = { item = item.copy(value = it) },
                        onDeleteClick = { item = item.copy(value = "") }
                    )
                }
            }
        }
    }
}