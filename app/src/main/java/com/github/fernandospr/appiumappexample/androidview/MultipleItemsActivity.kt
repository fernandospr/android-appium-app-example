package com.github.fernandospr.appiumappexample.androidview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.fernandospr.appiumappexample.databinding.ActivityMultipleBinding
import com.github.fernandospr.appiumappexample.databinding.ItemBinding
import com.github.fernandospr.appiumappexample.models.Item

class MultipleItemsActivity : AppCompatActivity() {

    private val items = (1..100).map { Item(it, "Item $it") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMultipleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = ItemsAdapter(items)
            layoutManager = LinearLayoutManager(this@MultipleItemsActivity)
        }
    }
}

class ItemsAdapter(private val items: List<Item>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(items[position])
    }

    inner class ItemViewHolder(binding: ItemBinding) : ViewHolder(binding.root) {
        private val editTextExample = binding.editTextExample
        private val textViewResult = binding.textViewResult
        private val buttonSet = binding.buttonSet
        private val buttonDelete = binding.buttonDelete

        fun bind(item: Item) {
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