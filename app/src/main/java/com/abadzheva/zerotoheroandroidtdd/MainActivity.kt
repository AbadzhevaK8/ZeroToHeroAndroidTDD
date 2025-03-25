package com.abadzheva.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.changeButton)
        val tv = findViewById<TextView>(R.id.titleTextView)
        btn.setOnClickListener {
            tv.text = getString(R.string.i_am_an_android_developer)
        }
    }
}