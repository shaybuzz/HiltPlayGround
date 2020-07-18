package com.tut.hiltplayground.view

import androidx.fragment.app.Fragment
import com.tut.hiltplayground.R
import com.tut.hiltplayground.repository.BlogsRepository
import javax.inject.Inject

class BlogsFragment @Inject constructor(blogsRepository: BlogsRepository) :
    Fragment(R.layout.fragment_main) {
}