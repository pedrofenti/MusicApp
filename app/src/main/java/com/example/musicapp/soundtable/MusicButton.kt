package com.example.musicapp.soundtable

import android.net.Uri
import android.os.Build
import android.text.BoringLayout
import androidx.annotation.RequiresApi
import java.time.Duration

class MusicButton(
    val ref: Uri = Uri.EMPTY,
    val title: String? = "title",
    val dur: Long? = 0L,
    val player: Boolean = false)
{

}