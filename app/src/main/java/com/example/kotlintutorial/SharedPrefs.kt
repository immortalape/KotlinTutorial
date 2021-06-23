package com.example.kotlintutorial

import android.app.Activity
import android.content.SharedPreferences

class SharedPrefs(activity: Activity) {

    private val sharedPrefs: SharedPreferences = activity.getSharedPreferences("kotlin", 0)

    fun saveHighScore(highScore: Int) {
        sharedPrefs.edit().putInt("high_score", highScore).apply()
    }

    val getHighScore = sharedPrefs.getInt("high_score", 0)

}