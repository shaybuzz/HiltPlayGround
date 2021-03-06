package com.tut.hiltplayground.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.tut.hiltplayground.repository.BlogsRepository
import javax.inject.Inject

class MainFragmentFactory @Inject constructor(
    private val blogsRepository: BlogsRepository,
    private val someStringSource: String
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            BlogsFragment::class.java.name -> {
                BlogsFragment(blogsRepository, someStringSource)
            }
            OtherFragment::class.java.name -> {
                OtherFragment(someStringSource)
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}