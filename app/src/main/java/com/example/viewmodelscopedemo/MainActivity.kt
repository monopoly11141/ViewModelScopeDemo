package com.example.viewmodelscopedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel : MainActivityViewModel
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //mainActivityViewModel.getUserData()

        mainActivityViewModel.users.observe(this, Observer{ myUsers ->
             myUsers.forEach{
                 Log.d(TAG, "name is ${it.name}")
             }
        })
    }
}