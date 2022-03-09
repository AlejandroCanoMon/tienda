package com.recu.tienda.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import androidx.room.Room

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.recu.tienda.R
import com.recu.tienda.data.database.Database
import com.recu.tienda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room.databaseBuilder(applicationContext,Database::class.java,"products").allowMainThreadQueries().fallbackToDestructiveMigration().build()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


    }
}

val Fragment.db: Database
    get() = (requireActivity() as MainActivity).db