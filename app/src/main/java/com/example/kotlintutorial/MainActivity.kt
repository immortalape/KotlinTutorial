package com.example.kotlintutorial

import android.content.SharedPreferences
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

        //Наши переменные
        val initialTimerValue: Long = 15000
        var score = 0
        var isStarted = false

        //Shared Preference (для сохранения кусков данных локально)
        val sharedPrefs: SharedPreferences = this.getSharedPreferences("kotlin_tutorial", 0)
        val editor = sharedPrefs.edit()
        editor.putInt("high_score", 5)
        editor.apply()

        //Для чтения данных из локального хранилища
        val highScoreSharedPrefs = sharedPrefs.getInt("high_score", 0)
        val name = sharedPrefs.getString("name", "not found")
        Log.d("debug", "onCreate: $highScoreSharedPrefs")
        Log.d("debug", "onCreate: $name")


        //Инициализация элементов UI
        val timerTextView = this.findViewById<TextView>(R.id.timer_tv)
        val scoreTextView = this.findViewById<TextView>(R.id.score_tv)
        val button = this.findViewById<Button>(R.id.tap_me_btn)

        //Создание LiveData
        val liveData = MutableLiveData<Int>()

        //Функция для расчета и вывода очков
        fun setScore() {
            score++
            scoreTextView.text = this.getString(R.string.score_string, score)
        }

        //Функция для сброса таймера и очков в исходное положение
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