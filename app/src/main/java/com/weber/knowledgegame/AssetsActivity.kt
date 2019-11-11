package com.weber.knowledgegame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_assets.*
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

/*
 * Created on 2019-11-12
 * @author YWeber
 */
class AssetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assets)
        val open: InputStream = assets.open("test")
        open.use {
            val reader: InputStreamReader = it.reader(Charset.defaultCharset())
            tvAssets.text = reader.readText()
        }
    }
}