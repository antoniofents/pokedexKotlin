package com.example.afentanes.pokedexkotlin.modelview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.bumptech.glide.BitmapTypeRequest
import com.example.afentanes.pokedexkotlin.Pokemon
import com.example.afentanes.pokedexkotlin.client.PokemonClientKotlin
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class PokemonViewModelImpl : PokemonViewModel, AndroidViewModel {


    var pokemonList: MutableLiveData<ArrayList<Pokemon>>?=null

    constructor(application: Application) : super(application) {
        initPokemonList()
    }


    fun getPokemonListData(): MutableLiveData<ArrayList<Pokemon>>? {
        pokemonList= pokemonList?:MutableLiveData<ArrayList<Pokemon>>()
        return pokemonList
    }

    override fun getFilteredResults(constraint: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun pokemonSelected(pokemon: Pokemon) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getImage(url: String): BitmapTypeRequest<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun initPokemonList(): Unit {
        var pokemonApi: PokemonClientKotlin = PokemonClientKotlin.getApi()
        var pokemonCall: Call<JsonObject> = pokemonApi.getAllPokemons();
        pokemonCall.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>) {
                Log.i("PokemonApi", "pokemons success {${response.body()}}");
                response.body()!!.getAsJsonArray("results")?.let {

                    var currentPokemons  =ArrayList<Pokemon>()
                    for (i in 0..it.size()-1) {
                        var pokemon = Pokemon(it.get(i).asJsonObject.get("url").asString, it.get(i).asJsonObject.get("name").asString)
                        currentPokemons?.add(pokemon)
                    }
                    (pokemonList?:MutableLiveData<ArrayList<Pokemon>>()).value=currentPokemons
                }

            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable) {
                Log.i("PokemonApi", "error");
            }
        })
    }




}