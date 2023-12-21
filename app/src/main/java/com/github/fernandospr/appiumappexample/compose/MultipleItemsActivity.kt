package com.github.fernandospr.appiumappexample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.fernandospr.appiumappexample.models.Item
import com.github.fernandospr.appiumappexample.ui.theme.AppiumAppExampleTheme

class MultipleItemsActivity : ComponentActivity() {

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
                            *(1..100).map { Item(it, "Item $it") }.toTypedArray()
                        )
                    }

                    LazyColumn {
                        items(selections.size) { index ->
                            ItemContainer(
                                item = selections[index],
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