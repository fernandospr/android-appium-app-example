package com.github.fernandospr.appiumappexample.androidview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.fernandospr.appiumappexample.databinding.ActivitySingleBinding
import com.github.fernandospr.appiumappexample.databinding.ItemBinding
import com.github.fernandospr.appiumappexample.models.Item

class SingleItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding

    private val item = Item(1, "Item 1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showItem(binding.item, item)
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