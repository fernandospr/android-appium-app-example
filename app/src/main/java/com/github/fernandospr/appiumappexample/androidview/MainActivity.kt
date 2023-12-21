package com.github.fernandospr.appiumappexample.androidview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.fernandospr.appiumappexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSingle.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SingleItemActivity::class.java
                )
            )
        }
        binding.buttonThree.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ThreeItemsActivity::class.java
                )
            )
        }
        binding.buttonRecyclerView.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MultipleItemsActivity::class.java
                )
            )
        }
    }
}