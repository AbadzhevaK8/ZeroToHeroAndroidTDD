package com.abadzheva.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtBtn = findViewById<Button>(R.id.changeButton)
        val hideBtn = findViewById<Button>(R.id.hideButton)
        tv = findViewById<TextView>(R.id.titleTextView)

        tv.text = savedInstanceState?.getString(KEY_TEXT) ?: getString(
            R
                .string
                .hello_world
        )

        tv.visibility = savedInstanceState?.getInt(KEY_VISIBILITY, View.VISIBLE) ?: View.VISIBLE

        hideBtn.setOnClickListener {
            tv.visibility = View.GONE
        }

        txtBtn.setOnClickListener {
            tv.text = getString(R.string.i_am_an_android_developer)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_TEXT, tv.text.toString())
        outState.putInt(KEY_VISIBILITY, tv.visibility)
    }


    companion object {
        private const val KEY_TEXT = "text_key"
        private const val KEY_VISIBILITY = "visibility_key"
    }
}