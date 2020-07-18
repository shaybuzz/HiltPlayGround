package com.tut.hiltplayground.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.tut.hiltplayground.R
import javax.inject.Inject

class OtherFragment @Inject constructor(private val someStringSource: String) :
    Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("###", "#### OtherFragment with $someStringSource")
    }
}