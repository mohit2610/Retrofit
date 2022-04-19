package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.time.LocalDate
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var mainVIewModel: MainVIewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService = RetrofitHelper.getInstance().create(RetrofitService::class.java)

        val repository =Repository(retrofitService)
        mainVIewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainVIewModel::class.java]
        mainVIewModel.posts.observe(this) { it ->
            when (it) {
                is Response.Loading -> {

                }
                is Response.Success -> {
                    it.data?.let {
                        Toast.makeText(this, it.title, Toast.LENGTH_LONG).show()
                        Log.d("POST",it.body)
                    }
                }
                is Response.ErrorMessage -> {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}