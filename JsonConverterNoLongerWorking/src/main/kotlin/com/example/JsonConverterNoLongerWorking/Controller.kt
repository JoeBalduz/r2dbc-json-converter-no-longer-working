package com.example.JsonConverterNoLongerWorking

import com.example.JsonConverterNoLongerWorking.database.House
import com.example.JsonConverterNoLongerWorking.database.HouseRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class Controller(private val houseRepository: HouseRepository) {

    /**
     * Retrieves all [House] from the database
     */
    @GetMapping("/houses")
    fun getHouses(): Flux<House> {
        return houseRepository.findAll()
    }
}