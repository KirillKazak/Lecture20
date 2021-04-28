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

    val textView by lazy {findViewById<TextView>(R.id.text_view)}
    val editText by lazy {findViewById<EditText>(R.id.edit_text)}
    val button by lazy {findViewById<Button>(R.id.button)}

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

        button.setOnClickListener {
                var callable : Callable<Int> = getDataFromCallable(editText.text.toString().toInt())
                var futureTask : FutureTask<Int> = FutureTask(callable)
                Thread(futureTask).start()
                textView.setText(futureTask.get().toString())
        }
    }

    fun getDataFromCallable(a: Int) : Callable<Int> {
        return Callable {
                var result = 0
                for (x in 2..a) {
                    result += x
                }
            return@Callable result
        }
    }
}