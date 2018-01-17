package com.example.afentanes.pokedexkotlin.modelview

import com.bumptech.glide.BitmapTypeRequest
import com.example.afentanes.pokedexkotlin.Pokemon


interface PokemonViewModel{

    fun getFilteredResults(constraint: String)
    fun initPokemonList();
    fun pokemonSelected(pokemon: Pokemon);
    fun getImage(url: String): BitmapTypeRequest<Any>

}