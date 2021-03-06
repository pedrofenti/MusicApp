package com.example.musicapp.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.example.musicapp.soundtable.SoundTableActivity
import com.example.musicapp.databinding.FragmentMainMenuBinding

class MainMenuFragment(private val menuTitle: String,
                       @DrawableRes private val menuImage: Int
                       , private val menuDescription: String
                       , private val position: Int
                       ) : Fragment() {

    constructor(): this("",0,"",0)

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainMenuBinding.inflate(inflater)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //binding.mainMenuProgress.visibility = View.INVISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener {
            //binding.mainMenuProgress.visibility = View.VISIBLE

            when(position) {
                0 -> Toast.makeText(view.context, "This feature is coming soon!", Toast.LENGTH_SHORT).show()
                1 -> startActivity(Intent(context, SoundTableActivity::class.java))
                2 -> Toast.makeText(view.context, "This feature is coming soon!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.menuTitleText.text = menuTitle
        binding.menuImage.setImageResource(menuImage)
        binding.menuDescriptionText.text = menuDescription
    }
}