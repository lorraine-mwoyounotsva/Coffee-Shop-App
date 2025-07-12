package com.example.coffeeshop.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.coffeeshop.databinding.ActivityLocationBinding

class LocationActivity : BaseActivity() {

    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener { finish() }

        binding.sendOrderButton.setOnClickListener {
            val address = binding.etAddress.text.toString().trim()

            if (address.isEmpty()) {
                Toast.makeText(this, "Please enter your delivery address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val instructions = binding.etInstructions.text.toString().trim()


            Toast.makeText(this, "Order confirmed! Delivery is on the way", Toast.LENGTH_LONG).show()


            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}