package com.abadzheva.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.changeButton)
        tv = findViewById<TextView>(R.id.titleTextView)

        tv.text = savedInstanceState?.getString(KEY_TEXT) ?: getString(
            R
                .string
                .hello_world
        )

        btn.setOnClickListener {
            tv.text = getString(R.string.i_am_an_android_developer)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_TEXT, tv.text.toString())
    }


    companion object {
        private const val KEY_TEXT = "text_key"
    }
}