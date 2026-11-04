package com.ruben.aplicaciones_clase.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.ruben.aplicaciones_clase.databinding.ItemSuperheroBinding

class SuperheroViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superhero: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superhero.name
        binding.ivSuperhero.load("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/" + superhero.superheroId
                + "-" + superhero.name.lowercase().replace(" ","-")+".jpg"
        )
    }
}