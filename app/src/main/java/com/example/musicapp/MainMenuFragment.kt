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
import java.lang.IllegalArgumentException


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener {
            //Entrar en la actividad dependiendo de la posicion del fragment
            //when(position) {
            //    0 -> startActivity(Intent(this, ))
            //    1 -> startActivity(Intent(this, ))
            //    2 -> startActivity(Intent(this, ))
            //}
        }

        view.findViewById<TextView>(R.id.menu_title_text).text = menu_title
        view.findViewById<ImageView>(R.id.menu_image).setImageResource(menu_image)
        view.findViewById<TextView>(R.id.menu_description_text).text = menu_description
    }
}