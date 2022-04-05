package com.example.musicapp.MediaPlayer

import android.app.Activity
import android.media.MediaPlayer
import com.example.musicapp.soundtable.SoundTable

object SoundPlayerManager {

    private var mediaPlayer1: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null

    fun recordMediaPlayer(){

    }

    fun playMediaPlayer(activity: Activity, globalTitle: Boolean){
        if (globalTitle){
            if (mediaPlayer1?.isPlaying == true){
                mediaPlayer1?.stop()
            }
            else if (mediaPlayer1 != null && mediaPlayer1?.isPlaying == false) {
                mediaPlayer1?.start()
            }
            else{
                mediaPlayer1 = MediaPlayer.create(activity, SoundTable.playOnFocus(globalTitle))
                mediaPlayer1?.start()
            }
        }
        else
        {
            if (mediaPlayer2?.isPlaying == true){
                mediaPlayer2?.stop()
            }
            else if (mediaPlayer2 != null && mediaPlayer2?.isPlaying == false) {
                mediaPlayer2?.start()
            }
            else{
                mediaPlayer2 = MediaPlayer.create(activity, SoundTable.playOnFocus(globalTitle))
                mediaPlayer2?.start()
            }
        }
    }

    fun pauseMediaPlayer(globalTitle: Boolean){
        if (globalTitle){
            if (mediaPlayer1?.isPlaying == true) mediaPlayer1?.pause()
        }
        else
        {
            if (mediaPlayer2?.isPlaying == true) mediaPlayer2?.pause()
        }
    }

    fun stopMediaPlayer(globalTitle: Boolean){
        if (globalTitle){
            if (mediaPlayer1?.isPlaying == true) mediaPlayer1?.stop()
        }
        else
        {
            if (mediaPlayer2?.isPlaying == true) mediaPlayer2?.stop()
        }
    }

    fun destroyMediaPlayers(){
        mediaPlayer1?.release()
        mediaPlayer2?.release()
    }
}