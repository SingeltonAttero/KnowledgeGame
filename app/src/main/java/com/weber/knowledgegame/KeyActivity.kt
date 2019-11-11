package com.weber.knowledgegame

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_key.*

/*
 * Created on 2019-11-10
 * @author YWeber
 */
class KeyActivity : AppCompatActivity() {
    private val stringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key)
        tvKey.setOnClickListener {
            val systemService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            systemService.showSoftInput(tvKey, InputMethodManager.SHOW_IMPLICIT)
        }
        tvKey.setOnKeyListener { _: View, _, event ->
            stringBuilder.setLength(0)
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    stringBuilder.append("down, ")
                }
                MotionEvent.ACTION_UP -> {
                    stringBuilder.append("up, ")
                }

            }
            stringBuilder.append("${event.keyCode}")
            stringBuilder.append("\n")
            stringBuilder.append(event.unicodeChar.toChar())
            tvKey.text = stringBuilder
            event.keyCode == KeyEvent.KEYCODE_BACK
        }
        tvKey.isFocusableInTouchMode = true
        tvKey.requestFocus()
    }
}