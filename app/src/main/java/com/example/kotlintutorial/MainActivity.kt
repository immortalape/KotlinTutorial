package com.example.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Инициализация элементов UI
        val timer = this.findViewById<TextView>(R.id.timer_tv)
        val button = this.findViewById<Button>(R.id.tap_me_btn)

        //Создание LiveData
        val liveData = MutableLiveData<Int>()

        //Обработка нажатия кнопок
        button.setOnClickListener {
            //Домашнее задание: Запустить таймер при нажатии на кнопку
        }

        //Таймер
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                liveData.value = millisUntilFinished.toInt()
            }

            override fun onFinish() {
                //Домашнее задание: показывать сообщение после завершения таймера
                // и вернуть таймер в исходное положение
            }
        }.start()

        //Наблюдение LiveData
        liveData.observe(this, { timerValue ->
            timer.text =
                this.getString(R.string.timer_string, timerValue/1000)
        })
    }
}