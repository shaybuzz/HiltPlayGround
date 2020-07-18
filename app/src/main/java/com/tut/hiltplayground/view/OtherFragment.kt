package com.tut.hiltplayground.view

import androidx.fragment.app.Fragment
import com.tut.hiltplayground.R
import javax.inject.Inject

class OtherFragment @Inject constructor(someStringSource: String) :
    Fragment(R.layout.fragment_main) {
}