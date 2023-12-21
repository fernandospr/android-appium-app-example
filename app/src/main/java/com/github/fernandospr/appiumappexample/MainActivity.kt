package com.github.fernandospr.appiumappexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.github.fernandospr.appiumappexample.compose.OptionContainer
import com.github.fernandospr.appiumappexample.compose.OptionsContainer
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
                                    text = "Android Views",
                                    onItemClick = {
                                        startActivity(
                                            Intent(
                                                this,
                                                com.github.fernandospr.appiumappexample.androidview.MainActivity::class.java
                                            )
                                        )
                                    }
                                )
                            },
                            {
                                OptionContainer(
                                    text = "Compose",
                                    onItemClick = {
                                        startActivity(
                                            Intent(
                                                this,
                                                com.github.fernandospr.appiumappexample.compose.MainActivity::class.java
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