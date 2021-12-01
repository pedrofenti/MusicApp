package com.example.musicapp.soundtable

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.databinding.ActivitySoundTableBinding
import java.io.File

class SoundTableActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoundTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySoundTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE

        supportActionBar?.hide()

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
    }

    private val openDocumentLauncher =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->

            if (uri == null) return@registerForActivityResult

            val input = contentResolver.openInputStream(uri)

            val file = File(uri.path ?: " ")

            binding.titlesound.text = file.name
        }


    private fun setButtonFunctionality(id: Int): View.OnClickListener {
        return View.OnClickListener {

            //TODO añadir un comprobante de que el boton tiene contenido para que no realice openDocumentLauncher en else

            if (SoundTable[id].ref != Uri.EMPTY)
            {
                SoundTable.add(id, MusicButton())
                openDocumentLauncher.launch(arrayOf("*/*"))
            }
            else
            {

            }




//            SoundTable.add(MusicButton("Jazz"))
//            SoundTable[id].title = "hola"

//            val f = File.createTempFile()


            // open file
            //
        }
    }


}