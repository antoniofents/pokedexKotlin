package com.example.afentanes.pokedexkotlin

import android.os.Parcel
import android.os.Parcelable
import com.example.afentanes.pokedexkotlin.client.PokemonClientKotlin.Companion.url

/**
 * Created by afentanes on 1/16/18.
 */
data class Pokemon ( var name:String)  : Parcelable  {

    var id:String=""
    var frontUrl:String=""
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    constructor ( url: String? ,  name:String):this(name){
        id=url?.split(PokemonUtil.patternPokemonIdUrl.toRegex())!!.get(2);
        frontUrl= "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }




    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }


}