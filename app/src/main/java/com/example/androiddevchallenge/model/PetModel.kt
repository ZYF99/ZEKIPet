package com.example.androiddevchallenge.model

data class PetModel(
    val id: Long? = null,
    val image: String? = null,
    val name: String? = null,
    val description: String? = null,
    val publisher: Publisher? = null,
    val time: Long? = System.currentTimeMillis()
)
