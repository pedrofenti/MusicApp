package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.example.musicapp.databinding.FragmentMainMenuBinding
import java.lang.IllegalArgumentException
import java.util.zip.Inflater


/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment(private val menu_title: String,
                       @DrawableRes private val menu_image: Int
                       , private val menu_description: String
                       , private val position: Int
                       ) : Fragment() {

    // TODO delete in future
    constructor(): this("",0,"",0)

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainMenuBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener {
            //Entrar en la actividad dependiendo de la posicion del fragment
            when(position) {
                0 -> startActivity(Intent(context, SoundTableActivity::class.java))
                1 -> startActivity(Intent(context, SoundTableActivity::class.java))
                2 -> startActivity(Intent(context, SoundTableActivity::class.java))
            }
        }

        binding.menuTitleText.text = menu_title
        binding.menuImage.setImageResource(menu_image)
        binding.menuDescriptionText.text = menu_description
    }

}