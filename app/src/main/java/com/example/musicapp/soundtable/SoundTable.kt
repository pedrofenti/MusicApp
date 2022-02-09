package com.example.musicapp.soundtable

import android.net.Uri

object SoundTable: ArrayList<MusicButton>()
{

    var player1 = MusicButton()
    var player2 =  MusicButton()

    val isPlaying = player1
    private var playerNumber = false

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

    fun setPlayer(musicButton: MusicButton): Boolean {
        if (musicButton == player1)
            return true
        else if (musicButton == player2)
            return false

        playerNumber = !playerNumber

        if (playerNumber)
            player1 = musicButton
        else
            player2 = musicButton

        return playerNumber
    }

}