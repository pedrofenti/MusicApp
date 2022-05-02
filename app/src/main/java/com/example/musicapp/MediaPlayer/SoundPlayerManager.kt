package com.example.musicapp.MediaPlayer

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import com.example.musicapp.soundtable.SoundTable

object SoundPlayerManager {

    private var mediaPlayer1: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null

    private var isMediaPlayer1Paused: Boolean = false
    private var isMediaPlayer2Paused: Boolean = false

    fun recordMediaPlayer() {

    }

    fun loadMediaPlayer(context: Context, globalTitle: Boolean): MediaPlayer? {
        if (globalTitle) {
            MediaPlayer.create(context, SoundTable.playOnFocus(globalTitle)).let {
                mediaPlayer1 = it
                return it
            }
        } else {
            MediaPlayer.create(context, SoundTable.playOnFocus(globalTitle)).let {
                mediaPlayer2 = it
                return it
            }
        }
    }

    fun playMediaPlayer(activity: Activity, globalTitle: Boolean) {
        if (globalTitle) {
            if (mediaPlayer1?.isPlaying == true) {
                pauseMediaPlayer(globalTitle)
            } else if (mediaPlayer1 != null && isMediaPlayer1Paused) {
                mediaPlayer1?.start()
            } else {
//                mediaPlayer1 = MediaPlayer.create(activity, SoundTable.playOnFocus(globalTitle))
                mediaPlayer1?.start()
            }
            isMediaPlayer1Paused = false

            println(mediaPlayer1?.duration)

        } else {
            if (mediaPlayer2?.isPlaying == true) {
                pauseMediaPlayer(globalTitle)
            } else if (mediaPlayer2 != null && isMediaPlayer2Paused) {
                mediaPlayer2?.start()
            } else {
//                mediaPlayer2 = MediaPlayer.create(activity, SoundTable.playOnFocus(globalTitle))
                mediaPlayer2?.start()
            }
            isMediaPlayer2Paused = false
        }
    }

    fun pauseMediaPlayer(globalTitle: Boolean) {
        if (globalTitle) {
            if (mediaPlayer1?.isPlaying == true) {
                mediaPlayer1?.pause()
                isMediaPlayer1Paused = true
            }
        } else {
            if (mediaPlayer2?.isPlaying == true) {
                mediaPlayer2?.pause()
                isMediaPlayer2Paused = true
            }
        }
    }

    fun stopMediaPlayer(globalTitle: Boolean) {
        if (globalTitle) {
            mediaPlayer1?.stop()
            isMediaPlayer1Paused = false
        } else {
            mediaPlayer2?.stop()
            isMediaPlayer2Paused = false
        }
    }

    fun destroyMediaPlayers() {
        mediaPlayer1?.release()
        mediaPlayer2?.release()
        isMediaPlayer1Paused = false
        isMediaPlayer2Paused = false
    }

    fun checkToUpdateMediaPlayer1() {

    }
}