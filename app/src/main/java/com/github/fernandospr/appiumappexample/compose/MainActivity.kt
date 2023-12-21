package com.github.fernandospr.appiumappexample.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.fernandospr.appiumappexample.ui.theme.AppiumAppExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppiumAppExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OptionsContainer(
                        composables = listOf(
                            {
                                OptionContainer(
                                    text = "Single Item",
                                    onItemClick = {
                                        startActivity(
                                            Intent(
                                                this,
                                                SingleItemActivity::class.java
                                            )
                                        )
                                    }
                                )
                            },
                            {
                                OptionContainer(
                                    text = "Three Items",
                                    onItemClick = {
                                        startActivity(
                                            Intent(
                                                this,
                                                ThreeItemsActivity::class.java
                                            )
                                        )
                                    }
                                )
                            },
                            {
                                OptionContainer(
                                    text = "Multiple Items",
                                    onItemClick = {
                                        startActivity(
                                            Intent(
                                                this,
                                                MultipleItemsActivity::class.java
                                            )
                                        )
                                    }
                                )
                            }
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OptionContainerPreview() {
    OptionsContainer(
        composables = listOf(
            {
                OptionContainer(text = "Option One")
            },
            {
                OptionContainer(text = "Option Two")
            },
            {
                OptionContainer(text = "Option Three")
            }
        )
    )
}

@Composable
fun OptionsContainer(
    composables: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        composables.forEach {
            it()
        }
    }
}

@Composable
fun OptionContainer(
    text: String,
    onItemClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onItemClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}