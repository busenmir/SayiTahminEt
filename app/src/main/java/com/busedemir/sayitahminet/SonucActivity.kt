package com.busedemir.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val sonuc = intent.getBooleanExtra("sonuc",false)
        if(sonuc){
            textViewSonuc.text="KAZANDINIZ"
            image_sad.setImageResource(R.drawable.happy)
        }else{
            textViewSonuc.text="KAYBETTİNİZ GERÇEK SAYI $rastgeleSayı"
            image_sad.setImageResource(R.drawable.sad)
        }
        buttonTekrar.setOnClickListener{
            val intent = Intent(applicationContext,TahminActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}