package com.example.JsonConverterNoLongerWorking.database

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HouseRepository : ReactiveCrudRepository<House, Int>