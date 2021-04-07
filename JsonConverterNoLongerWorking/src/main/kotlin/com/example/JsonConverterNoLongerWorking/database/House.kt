package com.example.JsonConverterNoLongerWorking.database

import org.springframework.data.annotation.Id

data class House(val address: String, val pets: List<Pet>, @Id var id: Int? = null)
