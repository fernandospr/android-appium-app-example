package com.github.fernandospr.appiumappexample.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.fernandospr.appiumappexample.models.Item

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ItemContainer(
    item: Item,
    onSetClick: (String) -> Unit = {},
    onDeleteClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.semantics { testTagsAsResourceId = true }) {
        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Input something...") },
                modifier = Modifier
                    .weight(1f)
                    .testTagWithPackage("editText_example")
            )
            Button(
                onClick = { onSetClick(text) },
                modifier = Modifier
                    .width(100.dp)
                    .testTagWithPackage("button_set")
            ) {
                Text(text = "Set")
            }
            Button(
                onClick = { onDeleteClick(); text = "" },
                modifier = Modifier
                    .width(100.dp)
                    .testTagWithPackage("button_delete")
            ) {
                Text(text = "Delete")
            }
        }
        Text(text = item.value, modifier = Modifier.testTagWithPackage("textView_result"))
    }
}

@Composable
@Preview
fun ItemContainerPreview() {
    ItemContainer(item = Item(1, "Item 1"))
}