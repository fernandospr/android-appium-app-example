package com.github.fernandospr.appiumappexample.androidview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.fernandospr.appiumappexample.databinding.ActivityThreeBinding
import com.github.fernandospr.appiumappexample.databinding.ItemBinding
import com.github.fernandospr.appiumappexample.models.Item

class ThreeItemsActivity : AppCompatActivity() {

    private val items = (1..3).map { Item(it, "Item $it") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        items.forEach {
            val itemBinding = ItemBinding.inflate(layoutInflater)
            showItem(itemBinding, it)
            binding.layoutDynamicRoot.addView(itemBinding.root)
        }
    }

    private fun showItem(itemBinding: ItemBinding, item: Item) {
        itemBinding.apply {
            editTextExample.setText("")
            textViewResult.text = item.value
            buttonSet.setOnClickListener {
                item.value = editTextExample.text.toString()
                textViewResult.text = item.value
            }
            buttonDelete.setOnClickListener {
                editTextExample.setText("")
                item.value = ""
                textViewResult.text = item.value
            }
        }
    }
}