package com.aliardal.vucutkitleendeksihesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aliardal.vucutkitleendeksihesaplama.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 200

        binding.weightPicker.setOnValueChangedListener{_,_,_->
            calculateVKE()
        }
        binding.heightPicker.setOnValueChangedListener{_,_,_->
            calculateVKE()
        }
    }
    private fun calculateVKE()
    {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value
        val doubleweight = weight.toDouble() / (doubleHeight * doubleHeight )


        binding.results.text = String.format("Vücut Kitle Endeksiniz: %f", doubleweight)

        binding.healthy.text = String.format("Durumunuz: %s", healthyMessage(doubleweight))

    }
    private fun healthyMessage(bmi:Double):String
    {
        if(bmi < 18.5)
            return "Zayıf"
        if(bmi < 25.0)
            return "Sağlıklı"
        if(bmi < 30.0)
            return "Kilolu"
        return "Obez"
    }
    fun tikla(view: View){
        intent = Intent(applicationContext,YagOraniHesaplama::class.java)
        startActivity(intent)
    }
}
