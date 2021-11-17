package com.example.musicapp

import android.content.Intent
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import com.google.android.material.appbar.AppBarLayout

class SoundTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_table)

        requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE

        supportActionBar?.hide()

    }



}