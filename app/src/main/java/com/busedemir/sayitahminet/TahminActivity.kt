package com.busedemir.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tahmin.*
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private var rastgeleSayı = 0
    private var sayac = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        rastgeleSayı = Random.nextInt(101)
        println("Rastgele Sayimiz $rastgeleSayı")

        Toast.makeText(applicationContext,"1 ile 50 arasında bir sayı var !",Toast.LENGTH_LONG).show()


        buttonTahmin.setOnClickListener{
            sayac = sayac - 1
            val tahmin = textViewGirdi.text.toString().toInt()
            var toplam = tahmin - rastgeleSayı
            if (tahmin == rastgeleSayı){
                val intent = Intent(applicationContext,SonucActivity::class.java)
                intent.putExtra("sonuc" , true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(toplam == 1){
                textViewYardim.text="Hey çok yaklaştın 1 azalt ya da artır"
                return@setOnClickListener
            }
            if (tahmin > rastgeleSayı){
                textViewYardim.text="Azalt"
                textViewKalanHak.text="Kalan Hakkınız : $sayac"
            }
            if (tahmin < rastgeleSayı){
                textViewYardim.text="Artır"
                textViewKalanHak.text="Kalan Hakkınız : $sayac"
            }
            if (sayac == 0){
                val intent = Intent(applicationContext,SonucActivity::class.java)
                intent.putExtra("sonuc" , false)
                finish()
                startActivity(intent)
            }
            textViewGirdi.setText("")

        }
    }
}