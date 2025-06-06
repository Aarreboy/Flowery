package com.example.myapplication.viewmodel
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Plant

class PlantViewModel : ViewModel() {
    private val _plants = mutableStateListOf<Plant>()
    val plants: List<Plant> = _plants

    fun addPlant(name: String) {
        _plants.add(Plant(name))
    }
}