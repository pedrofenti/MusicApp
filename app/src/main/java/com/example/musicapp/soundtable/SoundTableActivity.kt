package com.example.musicapp.soundtable

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.graphics.Color
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile
import com.example.musicapp.databinding.ActivitySoundTableBinding
import java.io.File
import kotlin.reflect.safeCast


class SoundTableActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoundTableBinding

    private lateinit var mediaPlayer: MediaPlayer

    private var globalId : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySoundTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE

        supportActionBar?.hide()

        //Inicializar todos los botones a nada
        SoundTable.initSoundTableArray()

        binding.stButton1.setOnClickListener(setButtonFunctionality(1))
        binding.stButton2.setOnClickListener(setButtonFunctionality(2))
        binding.stButton3.setOnClickListener(setButtonFunctionality(3))
        binding.stButton4.setOnClickListener(setButtonFunctionality(4))

        binding.stButton5.setOnClickListener(setButtonFunctionality(5))
        binding.stButton6.setOnClickListener(setButtonFunctionality(6))
        binding.stButton7.setOnClickListener(setButtonFunctionality(7))
        binding.stButton8.setOnClickListener(setButtonFunctionality(8))

        binding.stButton9.setOnClickListener(setButtonFunctionality(9))
        binding.stButton10.setOnClickListener(setButtonFunctionality(10))
        binding.stButton11.setOnClickListener(setButtonFunctionality(11))
        binding.stButton12.setOnClickListener(setButtonFunctionality(12))

        binding.stButton13.setOnClickListener(setButtonFunctionality(13))
        binding.stButton14.setOnClickListener(setButtonFunctionality(14))
        binding.stButton15.setOnClickListener(setButtonFunctionality(15))
        binding.stButton16.setOnClickListener(setButtonFunctionality(16))

        binding.stButton1.setOnLongClickListener(setLongClickButtonFunctionality(1))
        binding.stButton2.setOnLongClickListener(setLongClickButtonFunctionality(2))
        binding.stButton3.setOnLongClickListener(setLongClickButtonFunctionality(3))
        binding.stButton4.setOnLongClickListener(setLongClickButtonFunctionality(4))

        binding.stButton5.setOnLongClickListener(setLongClickButtonFunctionality(5))
        binding.stButton6.setOnLongClickListener(setLongClickButtonFunctionality(6))
        binding.stButton7.setOnLongClickListener(setLongClickButtonFunctionality(7))
        binding.stButton8.setOnLongClickListener(setLongClickButtonFunctionality(8))

        binding.stButton9.setOnLongClickListener(setLongClickButtonFunctionality(9))
        binding.stButton10.setOnLongClickListener(setLongClickButtonFunctionality(10))
        binding.stButton11.setOnLongClickListener(setLongClickButtonFunctionality(11))
        binding.stButton12.setOnLongClickListener(setLongClickButtonFunctionality(12))

        binding.stButton13.setOnLongClickListener(setLongClickButtonFunctionality(13))
        binding.stButton14.setOnLongClickListener(setLongClickButtonFunctionality(14))
        binding.stButton15.setOnLongClickListener(setLongClickButtonFunctionality(15))
        binding.stButton16.setOnLongClickListener(setLongClickButtonFunctionality(16))

        binding.stButtonPlay.setOnClickListener{
            if(mediaPlayer.isPlaying) mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(this, SoundTable[globalId].ref)
            mediaPlayer.start()
        }
    }

    override fun onResume() {
        super.onResume()
        for (i in 0..16) {
            val button : Button? = idToButton(i)
            val isAny = SoundTable.checkUriRef(i)
            if (!isAny){
                button?.setBackgroundColor(Color.BLACK)
            }
            else{
                button?.setBackgroundColor(Color.WHITE)
            }
        }
    }

    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
    fun formateSeconds(milliseconds: Long): String? {
        var finalTimerString = ""
        var secondsString = ""

        // Convert total duration into time
        val hours = (milliseconds / (1000 * 60 * 60)).toInt()
        val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
        val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()

        // Add hours if there
        if (hours > 0) {
            finalTimerString = "$hours:"
        }

        // Prepending 0 to seconds if it is one digit
        secondsString = if (seconds < 10) {
            "0$seconds"
        } else {
            "" + seconds
        }
        finalTimerString = "$finalTimerString$minutes:$secondsString"

        //      return  String.format("%02d Min, %02d Sec",
        //                TimeUnit.MILLISECONDS.toMinutes(milliseconds),
        //                TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
        //                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));

        // return timer string
        return finalTimerString
    }*/

    private val openDocumentLauncher =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            //TODO esto falla no se porqe
            if (uri == null) return@registerForActivityResult
            val input = contentResolver.openInputStream(uri)
            val file = DocumentFile.fromSingleUri(applicationContext, uri)


            SoundTable[globalId] = MusicButton(uri, file?.name, file?.length())

            val title = TextView::class.safeCast(checkTitles())
            title?.text = file?.name

            //binding.duration.text = file?.length().toString()
        }

    private fun idToButton(id: Int): Button? {
        return when (id) {
            1 -> binding.stButton1
            2 -> binding.stButton2
            3 -> binding.stButton3
            4 -> binding.stButton4
            5 -> binding.stButton5
            6 -> binding.stButton6
            7 -> binding.stButton7
            8 -> binding.stButton8
            9 -> binding.stButton9
            10 -> binding.stButton10
            11 -> binding.stButton11
            12 -> binding.stButton12
            13 -> binding.stButton13
            14 -> binding.stButton14
            15 -> binding.stButton15
            16 -> binding.stButton16
            else -> return null
        }
    }

    private fun setButtonFunctionality(id: Int): View.OnClickListener {
        return View.OnClickListener {
            globalId = id

            //Coger el boton que el usuario a elegido
            val button : Button? = idToButton(id)

            //Cambiar el titulo y la duracion del audio que se muestra
            //binding.titlesound.text = SoundTable[id].title
            //binding.duration.text = SoundTable[id].dur.toString()

            val title = TextView::class.safeCast(checkTitles())
            title?.text = SoundTable[id].title
        }
    }

    private fun setLongClickButtonFunctionality(id: Int): View.OnLongClickListener {
        return View.OnLongClickListener {
            if (SoundTable[id].ref == Uri.EMPTY) {
                globalId = id
                openDocumentLauncher.launch(arrayOf("audio/*"))

                val button : Button? = idToButton(id)
                button?.setBackgroundColor(Color.WHITE)
            }
            return@OnLongClickListener true
        }
    }


    private fun checkTitles() :TextView {
        if(binding.titlesound.text == "title.empty" || binding.titlesound.text == "title"){
            return binding.titlesound
        }
        else if(binding.titlesound2.text == "title.empty"|| binding.titlesound2.text == "title"){
            return binding.titlesound2
        }
        return binding.titlesound
    }
}