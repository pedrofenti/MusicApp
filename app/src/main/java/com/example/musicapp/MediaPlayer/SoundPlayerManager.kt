package com.example.musicapp.MediaPlayer

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Environment
import android.widget.Toast
import com.example.musicapp.soundtable.SoundTable
import java.io.File
import java.io.IOException

object SoundPlayerManager {

    var mediaPlayer1: MediaPlayer? = null
    var mediaPlayer2: MediaPlayer? = null

    var mediaRecorder: MediaRecorder? = null

    private var output: File? = null

    private var isMediaPlayer1Paused: Boolean = false
    private var isMediaPlayer2Paused: Boolean = false

    var isRecording: Boolean = false

    fun loadMediaRecorder() {
        mediaRecorder = MediaRecorder()
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)
    }

    fun recordMediaRecorder(context: Context) {
        isRecording = true;

        var SDCardpath = Environment.getExternalStorageDirectory()
        output = File(
            SDCardpath.getAbsolutePath()
                .toString() + "/.My Recordings"
        )


        try {
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            Toast.makeText(context, "Recording started!", Toast.LENGTH_SHORT).show()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun stopMediaRecorder(context: Context) {
        isRecording = false
        mediaRecorder?.stop()
        mediaRecorder?.release()
        Toast.makeText(context, "Recording ended!", Toast.LENGTH_SHORT).show()
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
            if (mediaPlayer1 != null && isMediaPlayer1Paused) {
                mediaPlayer1?.start()
            } else {
//                mediaPlayer1 = MediaPlayer.create(activity, SoundTable.playOnFocus(globalTitle))
                mediaPlayer1?.start()
            }
            isMediaPlayer1Paused = false

        } else {
            if (mediaPlayer2 != null && isMediaPlayer2Paused) {
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
        mediaRecorder?.release()
        isMediaPlayer1Paused = false
        isMediaPlayer2Paused = false
        isRecording = false
    }
}