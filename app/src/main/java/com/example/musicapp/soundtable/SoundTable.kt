package com.example.musicapp.soundtable

import android.net.Uri

object SoundTable: ArrayList<MusicButton>()
{
    var soundtitle: Boolean = true

    var lastId1: Int = 0
    var lastId2: Int = 0

    init {
        for (i in 0..16){
            SoundTable.add(i, MusicButton())
        }
    }

    fun checkUriRef (id: Int) : Boolean{
        if (SoundTable[id].reference == Uri.EMPTY){
            return false
        }
        return true
    }

    fun updateMusicButton(title: Boolean, i: Int) {
        soundtitle = title
        when(title){
            true -> lastId1 = i
            false -> lastId2 = i
        }
    }

    fun playOnFocus(title: Boolean) : Uri {
        when(title){
            true -> return SoundTable[lastId1].reference
            false -> return SoundTable[lastId2].reference
        }
    }
}

