package com.github.fernandospr.appiumappexample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.fernandospr.appiumappexample.models.Item
import com.github.fernandospr.appiumappexample.ui.theme.AppiumAppExampleTheme

class ThreeItemsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppiumAppExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val selections = remember {
                        mutableStateListOf(
                            *(1..3).map { Item(it, "Item $it") }.toTypedArray()
                        )
                    }

                    Column {
                        selections.forEachIndexed { index, item ->
                            ItemContainer(
                                item = item,
                                onSetClick = {
                                    selections[index] = selections[index].copy(value = it)
                                },
                                onDeleteClick = {
                                    selections[index] = selections[index].copy(value = "")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}