package com.example.kotlintutorial

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.getString(R.string.high_score_string, 5)


    }
}