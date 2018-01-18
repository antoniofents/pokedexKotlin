package com.example.afentanes.pokedexkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.afentanes.pokedexkotlin.Pokemon
import com.example.afentanes.pokedexkotlin.R
import com.example.afentanes.pokedexkotlin.modelview.PokemonViewModelImpl
import kotlinx.android.synthetic.main.pokemon_row.view.*


class PokemonListAdapter(var filteredList:List<Pokemon>, viewModelImpl: PokemonViewModelImpl):RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {
    class PokemonViewHolder(itemView: RelativeLayout) : RecyclerView.ViewHolder(itemView) {
        var view: RelativeLayout= itemView as RelativeLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PokemonViewHolder {
       var  view:RelativeLayout= LayoutInflater.from(parent!!.context).inflate(R.layout.pokemon_row, parent, false) as RelativeLayout
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
       var image= holder.view.poke_image
        var pokemon = filteredList.get(position)
        Glide.with(image.context).load(pokemon.frontUrl).into(image)
        holder.view.poke_name.text=pokemon.name
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }


     fun updateFilteredList(pokemons: List<Pokemon>) {
        this.filteredList = pokemons;

    }





}