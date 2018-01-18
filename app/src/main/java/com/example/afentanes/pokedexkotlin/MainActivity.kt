package com.example.afentanes.pokedexkotlin

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.afentanes.pokedexkotlin.adapter.PokemonListAdapter
import com.example.afentanes.pokedexkotlin.modelview.PokemonViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , LifecycleOwner {

    var lifeCycleRegistry: LifecycleRegistry?=null
    var  pokemonViewModel: PokemonViewModelImpl?=null
    var pokemonListAdapter : PokemonListAdapter?=null

    override fun getLifecycle(): LifecycleRegistry {
       return lifeCycleRegistry?: LifecycleRegistry(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifeCycleRegistry= getLifecycle()
        lifeCycleRegistry?.markState(Lifecycle.State.STARTED)
        pokemonViewModel  = ViewModelProviders.of(this).get(PokemonViewModelImpl::class.java);
        addObservers()

    }


    fun addObservers(){
        pokemonViewModel?.getPokemonListData()?.observe(this, Observer(this::updatePokemons))

    }



    fun updatePokemons(pokemons:List <Pokemon>?){
        if(pokemonListAdapter==null ){
            if(pokemons?.size!! >0){
                pokemonListAdapter= PokemonListAdapter(pokemons, pokemonViewModel!! )
                pokemon_list.adapter=pokemonListAdapter
                pokemon_list.layoutManager= LinearLayoutManager(this)
                pokemon_list.setHasFixedSize(true)
            }
        }else{

            if (pokemons!!.size == 0) {
                input_layout_search.setError("not found")
                input_layout_search.requestFocus()
                input_layout_search.isErrorEnabled=false
            } else {
                input_layout_search.isErrorEnabled=false
            }
            pokemonListAdapter?.updateFilteredList(pokemons!!)
            pokemonListAdapter?.notifyDataSetChanged()
        }
    }

}



