package com.example.afentanes.pokedexkotlin

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() , LifecycleOwner {

    var lifeCycleRegistry: LifecycleRegistry?=null


    override fun getLifecycle(): LifecycleRegistry {
       return lifeCycleRegistry?: LifecycleRegistry(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifeCycleRegistry= getLifecycle()
    }




}


