package com.example.musicapp.soundtable

import android.net.Uri

object SoundTable: ArrayList<MusicButton>()
{
    public fun initSoundTableArray()
    {
        for (i in 0..16){
            SoundTable.add(i, MusicButton())
        }
    }

    public fun checkUriRef (id: Int) : Boolean{
        if (SoundTable[id].ref == Uri.EMPTY){
            return false
        }
        return true
    }
}