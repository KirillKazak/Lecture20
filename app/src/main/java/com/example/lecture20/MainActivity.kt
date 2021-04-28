package com.example.lecture20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {

    val month = 3
    var season : String? = null

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

        val textView : TextView = findViewById(R.id.text_view)
        val editText : EditText = findViewById(R.id.edit_text)
        val button : Button = findViewById(R.id.button)

        button.setOnClickListener(View.OnClickListener {
            fun <Unit> onClick() {
                var callable : Callable<kotlin.Unit> = getDataFromCallable(editText)
                var futureTask : FutureTask<kotlin.Unit> = FutureTask(callable)
                Thread(futureTask).start()
                textView.setText(futureTask.get().toString())
            }
        })
    }

    fun getDataFromCallable(editText: EditText) : Callable<Unit> {
        val callable : Callable<Unit> = Callable {
            fun call(): Int {
                var result = 0
                for (x in 2..(editText.text.toString()).toInt()) {
                    result = result + x
                }
                return result
            }
        }
        return callable
    }
}