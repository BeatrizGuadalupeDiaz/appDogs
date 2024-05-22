package com.example.appdogs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appdogs.data.dogsRandom.ContentViewModelRandomDogs
import com.example.appdogs.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<ContentViewModelRandomDogs>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        callRandomDogs()
        observerRandomDogs()
    }
    private fun callRandomDogs(){
        //llamados de funciones de viewmodel
        viewModel.getImageDogRandom()
    }
    private fun observerRandomDogs() {
        // Se observa la variable LiveData del ViewModel
        viewModel.data.observe(this) {
            val imageUrl = it.data
            Picasso.get().load(imageUrl).into(binding.imgBtnDog)
        }
    }

}