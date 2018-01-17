package com.example.afentanes.pokedexkotlin.modelview

import android.util.Log
import com.bumptech.glide.BitmapTypeRequest
import com.example.afentanes.pokedexkotlin.Pokemon
import com.example.afentanes.pokedexkotlin.client.PokemonClientKotlin
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModelImpl: PokemonViewModel {
    override fun getFilteredResults(constraint: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun pokemonSelected(pokemon: Pokemon) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getImage(url: String): BitmapTypeRequest<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun initPokemonList() : Unit {
        var pokemonApi : PokemonClientKotlin = PokemonClientKotlin.getApi()
        var pokemonCall : Call<JsonObject> =pokemonApi.getAllPokemons();
    }

    class PokemonApiCallback : Callback<JsonObject> {

        override fun  onResponse(call : Call<JsonObject>?, response: Response<JsonObject>) {
            Log.i("PokemonApi", "pokemons success {${response.body()}}");
        }
        override fun  onFailure(call : Call<JsonObject>?, t: Throwable ) {
            Log.i("PokemonApi", "error");
        }


    }

}