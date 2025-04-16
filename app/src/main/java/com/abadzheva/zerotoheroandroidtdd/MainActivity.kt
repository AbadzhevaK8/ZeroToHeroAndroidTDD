package com.abadzheva.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isRemoved = false
    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtBtn = findViewById<Button>(R.id.changeButton)
        val hideBtn = findViewById<Button>(R.id.hideButton)
        val removeBtn = findViewById<Button>(R.id.removeButton)
        val rootLayout = findViewById<ViewGroup>(R.id.rootLayout)

        isRemoved = savedInstanceState?.getBoolean(KEY_REMOVED, false) ?: false
        removeBtn.isEnabled = !isRemoved

        if (!isRemoved) {
            tv = findViewById(R.id.titleTextView)
            tv?.text = savedInstanceState?.getString(KEY_TEXT) ?: getString(R.string.hello_world)
            tv?.visibility = savedInstanceState?.getInt(KEY_VISIBILITY, View.VISIBLE) ?: View.VISIBLE
        } else {
            val textView = rootLayout.findViewById<TextView>(R.id.titleTextView)
            if (textView != null) {
                rootLayout.removeView(textView)
            }
        }

        hideBtn.setOnClickListener {
            tv?.visibility = View.GONE
        }

        txtBtn.setOnClickListener {
            tv?.text = getString(R.string.i_am_an_android_developer)
        }

        removeBtn.setOnClickListener {
            tv?.let {
                (it.parent as? ViewGroup)?.removeView(it)
                isRemoved = true
                tv = null
            }
            removeBtn.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_REMOVED, isRemoved)
        tv?.let {
            outState.putString(KEY_TEXT, it.text.toString())
            outState.putInt(KEY_VISIBILITY, it.visibility)
        }
    }

    companion object {
        private const val KEY_TEXT = "text_key"
        private const val KEY_VISIBILITY = "visibility_key"
        private const val KEY_REMOVED = "removed_key"
    }
}
