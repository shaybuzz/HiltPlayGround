package com.tut.hiltplayground.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tut.hiltplayground.R
import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.repository.BlogsRepository
import com.tut.hiltplayground.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

@AndroidEntryPoint
class BlogsFragment @Inject constructor(private val blogsRepository: BlogsRepository, private val someSource:String) :
    Fragment(R.layout.fragment_main) {

    val blogsViewModel by viewModels<BlogsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("###", "### BlogsFragment onViewCreated $someSource")
        subscribeObservers()
        blogsViewModel.setState(MainDataState.GetBlogsEvents)
    }


    private fun subscribeObservers() {
        blogsViewModel.dataState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Success -> {
                    appendBlogsTitle(it.data)
                }
                is DataState.Loading -> {
                    onLoading(true)
                }
                is DataState.Error -> {
                    onError(it.exception?.message)
                }
            }
        })
    }

    private fun onError(msg: String?) {
        onLoading(false)
        if (msg.isNullOrEmpty()) {
            text.text = "Unknow error"
        } else {
            text.text = msg
        }
    }

    private fun appendBlogsTitle(blogs: List<Blog>) {
        onLoading(false)
        blogs.forEach {
            text.text = "${text.text}\n${it.title}"
        }

    }

    private fun onLoading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}