package com.example.kilouygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity()  {

    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var hesaplaButton: Button
    lateinit var dunyaKiloEdx : EditText
    lateinit var imgGiris : ImageView
    lateinit var sonucTxt : TextView

    val MARS : Double = 0.30
    val JUPITER : Double = 0.60
    val SATURN : Double = 0.51

    val kilo : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ElementTanimla()
        ImgTanimla()

        Hesapla()
    }

    fun ElementTanimla(){
        radioGroup = findViewById(R.id.rdGrup)
        hesaplaButton = findViewById(R.id.hesaplaBtn)
        dunyaKiloEdx = findViewById(R.id.dunyaKiloEdx)
        imgGiris = findViewById(R.id.girisImg)
        sonucTxt = findViewById(R.id.sonucTxt)
    }

    fun ImgTanimla(){
        Glide.with(this)
            .load(R.drawable.uzay)
            .into(imgGiris)
    }

    fun Hesapla(){
        hesaplaButton.setOnClickListener {
            RdBtnTanimla()

            if(dunyaKiloEdx.text.isNotEmpty()){
                var kilo : Double = dunyaKiloEdx.text.toString().toDouble()
                when (radioButton.text) {
                    "Mars" -> {
                        kilo -= kilo*MARS
                    }
                    "Jupiter" -> {
                        kilo += kilo*JUPITER
                    }
                    "Saturn" -> {
                        kilo += kilo*SATURN
                    }
                }

                sonucTxt.text = kilo.toString()
            }
        }
    }

    fun RdBtnTanimla(){
        val selectedOption : Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(selectedOption)

        Toast.makeText(this,"Seçili rdBtn"+radioButton.text,Toast.LENGTH_LONG).show()
    }

}