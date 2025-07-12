package com.example.coffeeshop.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.coffeeshop.databinding.ActivityPaymentBinding

class PaymentActivity : BaseActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.visaRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOtherPayments(binding.visaRadio.id)
            }
        }

        binding.mastercardRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOtherPayments(binding.mastercardRadio.id)
            }
        }

        binding.paypalRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOtherPayments(binding.paypalRadio.id)
            }
        }

        binding.cashRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOtherPayments(binding.cashRadio.id)
            }
        }

        binding.payButton.setOnClickListener {
            when {
                binding.visaRadio.isChecked -> processPayment("Visa")
                binding.mastercardRadio.isChecked -> processPayment("Mastercard")
                binding.paypalRadio.isChecked -> processPayment("PayPal")
                binding.cashRadio.isChecked -> processPayment("Cash on Delivery")
                else -> Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivBack.setOnClickListener { finish() }
    }

    private fun uncheckOtherPayments(selectedId: Int) {
        if (binding.visaRadio.id != selectedId) binding.visaRadio.isChecked = false
        if (binding.mastercardRadio.id != selectedId) binding.mastercardRadio.isChecked = false
        if (binding.paypalRadio.id != selectedId) binding.paypalRadio.isChecked = false
        if (binding.cashRadio.id != selectedId) binding.cashRadio.isChecked = false
    }

    private fun processPayment(method: String) {
        Toast.makeText(this, "Payment with $method successful!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LocationActivity::class.java))
    }
}