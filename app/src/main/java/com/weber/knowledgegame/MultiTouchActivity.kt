package com.weber.knowledgegame

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_multi_touch.*

/*
 * Created on 2019-11-09
 * @author YWeber
 */
class MultiTouchActivity : AppCompatActivity(), View.OnTouchListener {

    private val coordinatorString = StringBuilder()
    private val touched = Array(10) { false }
    private val x = Array(10) { 0.0F }
    private val y = Array(10) { 0.0F }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        v.performClick()
        coordinatorString.setLength(0)
        val pointerId = event.getPointerId(event.actionIndex)
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                saveCoordinate(true, pointerId, event)
            }
            MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                saveCoordinate(false, pointerId, event)
            }
            MotionEvent.ACTION_MOVE -> {
                val pointerCount = event.pointerCount
                for (i in 0 until pointerCount) {
                    val movePointerId = event.getPointerId(i)
                    saveCoordinate(true, movePointerId, event)
                }
            }
        }
        updateUi()
        return true
    }

    private fun saveCoordinate(touch: Boolean, pointerId: Int, event: MotionEvent) {
        touched[pointerId] = touch
        x[pointerId] = event.getX(event.actionIndex)
        y[pointerId] = event.getY(event.actionIndex)
    }

    private fun updateUi() {

        touched.forEachIndexed { i, it ->
            coordinatorString.append("№$i touch:$it ")
            coordinatorString.append("x = ${x[i]}, ")
            coordinatorString.append("y = ${y[i]}")
            coordinatorString.append("\n")
        }
        tvMultiTouch.text = coordinatorString
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_touch)
        containerMultiTouch.setOnTouchListener(this)
        updateUi()
    }

}

