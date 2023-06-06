package com.aliardal.vucutkitleendeksihesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aliardal.vucutkitleendeksihesaplama.databinding.ActivityYagOraniHesaplamaBinding

class YagOraniHesaplama : AppCompatActivity() {
    private lateinit var binding: ActivityYagOraniHesaplamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYagOraniHesaplamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 200

        binding.neckPicker.minValue = 10
        binding.neckPicker.maxValue = 90

        binding.waistPicker.minValue = 20
        binding.waistPicker.maxValue = 200

        binding.weightPicker.setOnValueChangedListener{_,_,_->
            calculateVYO()}
        binding.heightPicker.setOnValueChangedListener{_,_,_->
            calculateVYO()}
        binding.neckPicker.setOnValueChangedListener{_,_,_->
            calculateVYO()}
        binding.waistPicker.setOnValueChangedListener{_,_,_->
            calculateVYO()}
    }

    fun calculateVYO() {
        val height = binding.heightPicker.value.toDouble() / 100
        val weight = binding.weightPicker.value.toDouble()
        val neck = binding.neckPicker.value.toDouble()
        val waist = binding.waistPicker.value.toDouble()

        // İşlemi yapmak için Sabit Sayılar
        val k1 = if (binding.maleRadioButton.isChecked) 86.010  else 163.205
        val k2 = if (binding.maleRadioButton.isChecked) 70.041  else 97.684
        val k3 = if (binding.maleRadioButton.isChecked) 36.76   else 78.387

        val result = (k1 - (k2 * (height / weight)) + (k3 * (neck / waist))).toString()
        val bodyFatPercentage = ((result.toDouble() / weight) * 100).toString()
        binding.bodyFat.text = bodyFatPercentage
        binding.bodyFat.text = result
    }
}
