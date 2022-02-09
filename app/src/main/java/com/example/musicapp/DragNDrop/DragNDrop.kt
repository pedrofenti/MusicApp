package com.example.musicapp.DragNDrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivityDragNdropBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlin.reflect.safeCast

class DragNDrop : AppCompatActivity() {

    private lateinit var binding: ActivityDragNdropBinding

    private val chipsLabel = listOf(
        "Blue supergiant", "Sun-Like Star", "Red Dwarf", "Brown Dwarf", "Red Giant",// 1st phase
        "Supernova", "Blackhole", "Neutron Star", "White Dwarf", // 2nd phase
        "Neutrino", "Chupa-chups", // Not star life
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDragNdropBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chipsLabel.forEach {
            val chip = Chip(this)
            chip.text = it

            chip.setOnTouchListener { view, motionEvent ->
                val shadow = View.DragShadowBuilder(chip)
                chip.startDragAndDrop(null, shadow, chip, 0)

            }
            binding.chipGroupTop.addView(chip)
        }

        binding.chipGroupDown.setOnDragListener(moveDragListener)
        binding.chipGroupTop.setOnDragListener(moveDragListener)

        binding.chipTrash.alpha = 0f
        binding.chipTrash.setOnDragListener(removeDragListener)
    }

    private val moveDragListener = View.OnDragListener { view, dragEvent ->

        val chip = Chip::class.safeCast(dragEvent.localState) ?: return@OnDragListener false

        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                chip.setTextColor(0x000000)
                chip.setBackgroundColor(0x000000)
                chip.setChipStrokeColorResource(R.color.black)
                chip.chipStrokeWidth = 4f
            }

            DragEvent.ACTION_DROP -> {
                ChipGroup::class.safeCast(chip.parent)?.removeView(chip)
                ChipGroup::class.safeCast(view)?.addView(chip)
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                chip.setTextColor(getColor(R.color.black))
                chip.setBackgroundColor(getColor(R.color.white))
                chip.chipStrokeWidth = 0f
            }
        }

        true
    }

    private val removeDragListener = View.OnDragListener { view, dragEvent ->

        val chip = Chip::class.safeCast(dragEvent.localState) ?: return@OnDragListener false

        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                binding.chipTrash.animate().alpha(1f)
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                binding.chipTrash.animate().scaleX(1.6f).scaleY(1.6f)
            }

            DragEvent.ACTION_DRAG_EXITED -> {
                binding.chipTrash.animate().scaleX(1f).scaleY(1f)
            }

            DragEvent.ACTION_DROP -> {
                ChipGroup::class.safeCast(chip.parent)?.removeView(chip)
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                binding.chipTrash.animate().scaleX(0f).scaleY(0f).withEndAction{
                    binding.chipTrash.scaleX = 1f
                    binding.chipTrash.scaleY = 1f
                    binding.chipTrash.alpha = 0f
                }
            }
        }
        true
    }

}