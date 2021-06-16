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

        val initialTimerValue: Long = 5000
        var isStarted = false
        var score = 0

        //Инициализация элементов UI
        val timerTextView = this.findViewById<TextView>(R.id.timer_tv)
        val scoreTextView = this.findViewById<TextView>(R.id.score_tv)
        val button = this.findViewById<Button>(R.id.tap_me_btn)

        //Создание LiveData
        val liveData = MutableLiveData<Int>()

        fun setScore() {
            score++
            scoreTextView.text = this.getString(R.string.score_string, score)
        }

        fun resetGame() {
            score = 0
            scoreTextView.text = this.getString(R.string.score_string, score)
            timerTextView.text =
                this.getString(R.string.timer_string, initialTimerValue / 1000)
            isStarted = false
        }

        //Таймер
        val countdownTimer =
            object : CountDownTimer(initialTimerValue, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    liveData.value = millisUntilFinished.toInt()
                }

                override fun onFinish() {
                    //Домашнее задание: показывать сообщение после завершения таймера
                    // и вернуть таймер в исходное положение
                    Toast.makeText(
                        this@MainActivity,
                        "Поздравляю, вы набрали .. очков",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    resetGame()
                }
            }

        //Обработка нажатия кнопок
        button.setOnClickListener {
            //Домашнее задание: Запустить таймер при нажатии на кнопку
            if (!isStarted) {
                countdownTimer.start()
                isStarted = true
            }
            setScore()
        }

        //Наблюдение LiveData
        liveData.observe(this, { timerValue ->
            timerTextView.text =
                this.getString(R.string.timer_string, timerValue / 1000)
        })
    }
}