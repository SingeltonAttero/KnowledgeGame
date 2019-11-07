package com.weber.knowledgegame

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_life_circle.*

/*
 * Created by YWeber on 2019-11-07.
 */
class LifeCircleActivity : AppCompatActivity(){

    private val stringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate")
        setContentView(R.layout.activity_life_circle)
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
        tvLifeCircle.text = stringBuilder
    }

    override fun onPause() {
        log("onPause")
        if (isFinishing){
            log("onPause + isFinishing")
        }
        super.onPause()
    }

    private fun log(name:String){
        Log.d("log",name)
        stringBuilder.append(name)
        stringBuilder.append("\n")
    }
}