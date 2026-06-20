package com.example.coffeeapp.data

import androidx.annotation.DrawableRes

data class Coffee(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val reviews: Int,
    @DrawableRes val image: Int,
    val category: String
)
