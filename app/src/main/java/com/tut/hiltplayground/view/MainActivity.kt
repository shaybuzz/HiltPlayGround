package com.tut.hiltplayground.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tut.hiltplayground.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var fragmentFactory: MainFragmentFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, BlogsFragment::class.java, null).commit()
    }

}