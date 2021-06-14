package com.example.kotlintutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData

class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.getString(R.string.high_score_string, 5)

        val liveDate = MutableLiveData<Int>()

        liveDate.observe(viewLifecycleOwner, {})


    }
}