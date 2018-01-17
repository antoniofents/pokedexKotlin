package com.example.afentanes.pokedexkotlin.client

import com.example.afentanes.pokedexkotlin.Pokemon
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface PokemonClientKotlin {



    @GET("/api/v2/pokemon/?limit=150")
    fun getAllPokemons(): Call<JsonObject> ;

    companion object {
        val url:String= "https://pokeapi.co/"
        fun getApi() :PokemonClientKotlin{
            var okHttpClient : OkHttpClient = OkHttpClient.Builder().connectTimeout(300, TimeUnit.SECONDS).build();
            var adapter : Retrofit = Retrofit.Builder().baseUrl(url).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
            var pokemonApi : PokemonClientKotlin =  adapter.create(PokemonClientKotlin::class.java)
            return pokemonApi
        }
    }
}

