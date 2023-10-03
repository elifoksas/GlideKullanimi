package com.elifoksas.glidekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.elifoksas.glidekullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //http://kasimadalan.pe.hu/yemekler/resimler/pizza.png

        resimGoster("kofte.png")

        binding.buttonResim1.setOnClickListener {
            resimGoster("ayran.png")
        }
        binding.buttonResim2.setOnClickListener {
            resimGoster("su.png")
        }
        binding.buttonRastgele.setOnClickListener {
            val yemeklerListesi = listOf("ayran.png","baklava.png","fanta.png",
                "izgarasomon.png", "izgaratavuk.png","kadayif.png","kahve.png",
                "kofte.png", "lazanya.png", "makarna.png", "pizza.png",
                "su.png", "sutlac.png", "tiramisu.png")//0-13

            val yemek = yemeklerListesi.random()
            resimGoster(yemek)
        }
    }

    fun resimGoster(resimAdi:String){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(this).load(url).override(500,500).into(binding.imageViewYemek)
    }
}