package com.example.musicapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.musicapp.main.MainMenuFragment
import com.example.musicapp.R
import java.lang.IllegalArgumentException

private val TAB_TITLES = arrayOf(
    R.string.instruments,
    R.string.sound_table,
    R.string.karaoke
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        val fragment = when(position) {
            0 -> MainMenuFragment(context.getString(R.string.instruments), R.drawable.instruments, context.getString(R.string.instruments_desc), position)
            1 -> MainMenuFragment(context.getString(R.string.sound_table), R.drawable.soundtable, context.getString(R.string.soundtable_desc), position)
            2 -> MainMenuFragment(context.getString(R.string.karaoke), R.drawable.karaoke, context.getString(R.string.karaoke_desc), position)
            else -> throw IllegalArgumentException()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}