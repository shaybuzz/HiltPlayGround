package com.tut.hiltplayground.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tut.hiltplayground.R
import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val blogsViewModel by viewModels<BlogsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObservers()
        blogsViewModel.setState(MainDataState.GetBlogsEvents)
    }

    private fun subscribeObservers() {
        blogsViewModel.dataState.observe(this, Observer {
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

    private fun onError(msg:String?) {
        onLoading(false)
        if(msg.isNullOrEmpty()){
            text.text = "Unknow error"
        }else{
            text.text = msg
        }
    }

    private fun appendBlogsTitle(blogs:List<Blog>) {
        onLoading(false)
        blogs.forEach {
            text.text = "${text.text}\n${it.title}"
        }

    }

    private fun onLoading(isLoading: Boolean) {
        progress.visibility = if(isLoading) View.VISIBLE else View.GONE
    }
}