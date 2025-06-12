package com.example.myapplication.model

data class Plant(
    var lastWatered: Long = System.currentTimeMillis(),
    val name: String)
