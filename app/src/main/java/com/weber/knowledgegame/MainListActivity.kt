package com.weber.knowledgegame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_knowledge_list.*

/*
 * Created on 2019-11-06
 * @author YWeber
 */
class MainListActivity : AppCompatActivity() {
    private val featureKnowledge: List<String> = listOf(
        "LifeCircle", "SingleTouch",
        "MultiTouch", "Key", "Accelerometer",
        "Assets", "ExternalStorage", "SoundPool",
        "MediaPlayer", "FullScreen", "RenderView",
        "Shape", "Bitmap", "Font", "SurfaceView"
    )
    private val adapter by lazy { ListKnowledgeAdapter(featureKnowledge, ::clickEvent) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_list)
        rvKnowledge.adapter = adapter
    }

    private fun clickEvent(name: String) {
        try {

            val nextScreen = Class.forName("${BuildConfig.APPLICATION_ID}.${name}Activity")
            startActivity(Intent(this,nextScreen))
        } catch (ex: ClassNotFoundException) {
            Log.e("error", ex.printStackTrace().toString())
        }
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }
}