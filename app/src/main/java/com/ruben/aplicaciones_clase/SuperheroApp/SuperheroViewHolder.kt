package com.ruben.aplicaciones_clase.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.ruben.aplicaciones_clase.databinding.ItemSuperheroBinding

class SuperheroViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superhero: SuperheroItemResponse, navigateToDetailActivity: (String) -> Unit) {
        binding.tvSuperheroName.text = superhero.name
        binding.ivSuperhero.load(superhero.superheroImage.url)
        binding.root.setOnClickListener { navigateToDetailActivity(superhero.superheroId) }
    }
}