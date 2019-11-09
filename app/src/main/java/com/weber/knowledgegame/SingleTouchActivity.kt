package com.weber.knowledgegame

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_single_touch.*

/*
 * Created on 2019-11-08
 * @author YWeber
 */
class SingleTouchActivity : AppCompatActivity() {

    private val coordinateBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_touch)
        containerSingleTouch.setOnTouchListener { _, event ->
            coordinateBuilder.setLength(0)
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    coordinateBuilder.append("down, ")
                }
                MotionEvent.ACTION_MOVE -> {
                    coordinateBuilder.append("move, ")
                }
                MotionEvent.ACTION_UP -> {
                    coordinateBuilder.append("up, ")
                }
                MotionEvent.ACTION_CANCEL -> {
                    coordinateBuilder.append("cancel")
                }
            }
            coordinateBuilder.append("\n")
            coordinateBuilder.append("x = ${event.x}")
            coordinateBuilder.append("\n")
            coordinateBuilder.append("y = ${event.y}")
            tvSingleTouch.text = coordinateBuilder
            true
        }
    }

}