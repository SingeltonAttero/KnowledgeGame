package com.weber.knowledgegame

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_accelerometer.*

/*
 * Created on 2019-11-10
 * @author YWeber
 */
class AccelerometerActivity : AppCompatActivity(),SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        val coordinates = "x: ${event.values[0]}, y: ${event.values[1]}, z ${event.values[2]}"
        tvAccelerometer.text = coordinates
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size == 0){
            tvAccelerometer.text = getString(R.string.not_installed_accelerometer)
        }else{
            val accelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)[0]
            if (sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_GAME)){

            }
        }
    }
}