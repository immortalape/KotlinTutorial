package com.example.kotlintutorial

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.getString(R.string.high_score_string, 5)

        //Объявление переменных
        val age = 34 //Integer числовое значение
        val name = "Ashot" //String Текстовое значение
        val isHuman = true //Boolean значение для сохранения состояния

        println("$age, $name, $isHuman")

    }
}