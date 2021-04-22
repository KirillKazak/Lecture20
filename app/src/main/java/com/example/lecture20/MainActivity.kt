package com.example.lecture20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    val month = 3;
    var season : String? = null;
    val editText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (month) {
            1,2,12 -> season = "Зимушка зима"
            3,4,5 -> season = "Весна"
            6,7,8 -> season = "Лето"
            9,10,11 -> "Осень"
            else -> season = "Не знаю"
        }
        Log.d("TAG", season.toString())
    }
}