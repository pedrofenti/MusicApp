package com.example.musicapp

import android.content.Intent
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import com.google.android.material.appbar.AppBarLayout
import java.io.File

class SoundTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_table)

        requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE

        supportActionBar?.hide()

        findViewById<Button>(R.id.stButton1).setOnClickListener(setButtonFunctionality(1))
        findViewById<Button>(R.id.stButton2).setOnClickListener(setButtonFunctionality(2))
        findViewById<Button>(R.id.stButton3).setOnClickListener(setButtonFunctionality(3))
        findViewById<Button>(R.id.stButton4).setOnClickListener(setButtonFunctionality(4))

        findViewById<Button>(R.id.stButton5).setOnClickListener(setButtonFunctionality(5))
        findViewById<Button>(R.id.stButton6).setOnClickListener(setButtonFunctionality(6))
        findViewById<Button>(R.id.stButton7).setOnClickListener(setButtonFunctionality(7))
        findViewById<Button>(R.id.stButton8).setOnClickListener(setButtonFunctionality(8))

        findViewById<Button>(R.id.stButton9).setOnClickListener(setButtonFunctionality(9))
        findViewById<Button>(R.id.stButton10).setOnClickListener(setButtonFunctionality(10))
        findViewById<Button>(R.id.stButton11).setOnClickListener(setButtonFunctionality(11))
        findViewById<Button>(R.id.stButton12).setOnClickListener(setButtonFunctionality(12))

        findViewById<Button>(R.id.stButton13).setOnClickListener(setButtonFunctionality(13))
        findViewById<Button>(R.id.stButton14).setOnClickListener(setButtonFunctionality(14))
        findViewById<Button>(R.id.stButton15).setOnClickListener(setButtonFunctionality(15))
        findViewById<Button>(R.id.stButton16).setOnClickListener(setButtonFunctionality(16))


    }

    private fun setButtonFunctionality(id: Int): View.OnClickListener {
        return View.OnClickListener {



//            SoundTable.add(MusicButton("Jazz"))
//            SoundTable[id].title = "hola"

//            val f = File.createTempFile()


            // open file
            //
        }
    }


}